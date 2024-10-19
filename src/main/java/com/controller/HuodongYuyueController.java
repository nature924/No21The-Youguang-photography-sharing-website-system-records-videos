
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 活动报名
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/huodongYuyue")
public class HuodongYuyueController {
    private static final Logger logger = LoggerFactory.getLogger(HuodongYuyueController.class);

    private static final String TABLE_NAME = "huodongYuyue";

    @Autowired
    private HuodongYuyueService huodongYuyueService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private ForumService forumService;//论坛
    @Autowired
    private HuodongService huodongService;//活动
    @Autowired
    private HuodongCollectionService huodongCollectionService;//活动收藏
    @Autowired
    private HuodongLiuyanService huodongLiuyanService;//活动留言
    @Autowired
    private NewsService newsService;//公告资讯
    @Autowired
    private SucaiService sucaiService;//图片素材
    @Autowired
    private SucaiCollectionService sucaiCollectionService;//图片素材收藏
    @Autowired
    private SucaiLiuyanService sucaiLiuyanService;//图片素材留言
    @Autowired
    private SucaishipinService sucaishipinService;//视频素材
    @Autowired
    private SucaishipinCollectionService sucaishipinCollectionService;//视频素材收藏
    @Autowired
    private SucaishipinLiuyanService sucaishipinLiuyanService;//视频素材留言
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = huodongYuyueService.queryPage(params);

        //字典表数据转换
        List<HuodongYuyueView> list =(List<HuodongYuyueView>)page.getList();
        for(HuodongYuyueView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        HuodongYuyueEntity huodongYuyue = huodongYuyueService.selectById(id);
        if(huodongYuyue !=null){
            //entity转view
            HuodongYuyueView view = new HuodongYuyueView();
            BeanUtils.copyProperties( huodongYuyue , view );//把实体数据重构到view中
            //级联表 活动
            //级联表
            HuodongEntity huodong = huodongService.selectById(huodongYuyue.getHuodongId());
            if(huodong != null){
            BeanUtils.copyProperties( huodong , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setHuodongId(huodong.getId());
            }
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(huodongYuyue.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody HuodongYuyueEntity huodongYuyue, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,huodongYuyue:{}",this.getClass().getName(),huodongYuyue.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            huodongYuyue.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<HuodongYuyueEntity> queryWrapper = new EntityWrapper<HuodongYuyueEntity>()
            .eq("huodong_id", huodongYuyue.getHuodongId())
            .eq("yonghu_id", huodongYuyue.getYonghuId())
            .in("huodong_yuyue_yesno_types", new Integer[]{1,2})
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        HuodongYuyueEntity huodongYuyueEntity = huodongYuyueService.selectOne(queryWrapper);
        if(huodongYuyueEntity==null){
            huodongYuyue.setHuodongYuyueYesnoTypes(1);
            huodongYuyue.setInsertTime(new Date());
            huodongYuyue.setCreateTime(new Date());
            huodongYuyueService.insert(huodongYuyue);
            return R.ok();
        }else {
            if(huodongYuyueEntity.getHuodongYuyueYesnoTypes()==1)
                return R.error(511,"有相同的待审核的数据");
            else if(huodongYuyueEntity.getHuodongYuyueYesnoTypes()==2)
                return R.error(511,"有相同的审核通过的数据");
            else
                return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody HuodongYuyueEntity huodongYuyue, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,huodongYuyue:{}",this.getClass().getName(),huodongYuyue.toString());
        HuodongYuyueEntity oldHuodongYuyueEntity = huodongYuyueService.selectById(huodongYuyue.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            huodongYuyue.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            huodongYuyueService.updateById(huodongYuyue);//根据id更新
            return R.ok();
    }


    /**
    * 审核
    */
    @RequestMapping("/shenhe")
    public R shenhe(@RequestBody HuodongYuyueEntity huodongYuyueEntity, HttpServletRequest request){
        logger.debug("shenhe方法:,,Controller:{},,huodongYuyueEntity:{}",this.getClass().getName(),huodongYuyueEntity.toString());

        HuodongYuyueEntity oldHuodongYuyue = huodongYuyueService.selectById(huodongYuyueEntity.getId());//查询原先数据

//        if(huodongYuyueEntity.getHuodongYuyueYesnoTypes() == 2){//通过
//            huodongYuyueEntity.setHuodongYuyueTypes();
//        }else if(huodongYuyueEntity.getHuodongYuyueYesnoTypes() == 3){//拒绝
//            huodongYuyueEntity.setHuodongYuyueTypes();
//        }
        huodongYuyueEntity.setHuodongYuyueShenheTime(new Date());//审核时间
        huodongYuyueService.updateById(huodongYuyueEntity);//审核

        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<HuodongYuyueEntity> oldHuodongYuyueList =huodongYuyueService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        huodongYuyueService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<HuodongYuyueEntity> huodongYuyueList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            HuodongYuyueEntity huodongYuyueEntity = new HuodongYuyueEntity();
//                            huodongYuyueEntity.setHuodongYuyueUuidNumber(data.get(0));                    //报名编号 要改的
//                            huodongYuyueEntity.setHuodongId(Integer.valueOf(data.get(0)));   //活动 要改的
//                            huodongYuyueEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            huodongYuyueEntity.setHuodongYuyueText(data.get(0));                    //报名理由 要改的
//                            huodongYuyueEntity.setHuodongYuyueYesnoTypes(Integer.valueOf(data.get(0)));   //报名状态 要改的
//                            huodongYuyueEntity.setHuodongYuyueYesnoText(data.get(0));                    //审核回复 要改的
//                            huodongYuyueEntity.setHuodongYuyueShenheTime(sdf.parse(data.get(0)));          //审核时间 要改的
//                            huodongYuyueEntity.setInsertTime(date);//时间
//                            huodongYuyueEntity.setCreateTime(date);//时间
                            huodongYuyueList.add(huodongYuyueEntity);


                            //把要查询是否重复的字段放入map中
                                //报名编号
                                if(seachFields.containsKey("huodongYuyueUuidNumber")){
                                    List<String> huodongYuyueUuidNumber = seachFields.get("huodongYuyueUuidNumber");
                                    huodongYuyueUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> huodongYuyueUuidNumber = new ArrayList<>();
                                    huodongYuyueUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("huodongYuyueUuidNumber",huodongYuyueUuidNumber);
                                }
                        }

                        //查询是否重复
                         //报名编号
                        List<HuodongYuyueEntity> huodongYuyueEntities_huodongYuyueUuidNumber = huodongYuyueService.selectList(new EntityWrapper<HuodongYuyueEntity>().in("huodong_yuyue_uuid_number", seachFields.get("huodongYuyueUuidNumber")));
                        if(huodongYuyueEntities_huodongYuyueUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(HuodongYuyueEntity s:huodongYuyueEntities_huodongYuyueUuidNumber){
                                repeatFields.add(s.getHuodongYuyueUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [报名编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        huodongYuyueService.insertBatch(huodongYuyueList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = huodongYuyueService.queryPage(params);

        //字典表数据转换
        List<HuodongYuyueView> list =(List<HuodongYuyueView>)page.getList();
        for(HuodongYuyueView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        HuodongYuyueEntity huodongYuyue = huodongYuyueService.selectById(id);
            if(huodongYuyue !=null){


                //entity转view
                HuodongYuyueView view = new HuodongYuyueView();
                BeanUtils.copyProperties( huodongYuyue , view );//把实体数据重构到view中

                //级联表
                    HuodongEntity huodong = huodongService.selectById(huodongYuyue.getHuodongId());
                if(huodong != null){
                    BeanUtils.copyProperties( huodong , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setHuodongId(huodong.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(huodongYuyue.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody HuodongYuyueEntity huodongYuyue, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,huodongYuyue:{}",this.getClass().getName(),huodongYuyue.toString());
        Wrapper<HuodongYuyueEntity> queryWrapper = new EntityWrapper<HuodongYuyueEntity>()
            .eq("huodong_yuyue_uuid_number", huodongYuyue.getHuodongYuyueUuidNumber())
            .eq("huodong_id", huodongYuyue.getHuodongId())
            .eq("yonghu_id", huodongYuyue.getYonghuId())
            .eq("huodong_yuyue_text", huodongYuyue.getHuodongYuyueText())
            .in("huodong_yuyue_yesno_types", new Integer[]{1,2})
            .eq("huodong_yuyue_yesno_text", huodongYuyue.getHuodongYuyueYesnoText())
//            .notIn("huodong_yuyue_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        HuodongYuyueEntity huodongYuyueEntity = huodongYuyueService.selectOne(queryWrapper);
        if(huodongYuyueEntity==null){
            huodongYuyue.setHuodongYuyueYesnoTypes(1);
            huodongYuyue.setInsertTime(new Date());
            huodongYuyue.setCreateTime(new Date());
        huodongYuyueService.insert(huodongYuyue);

            return R.ok();
        }else {
            if(huodongYuyueEntity.getHuodongYuyueYesnoTypes()==1)
                return R.error(511,"有相同的待审核的数据");
            else if(huodongYuyueEntity.getHuodongYuyueYesnoTypes()==2)
                return R.error(511,"有相同的审核通过的数据");
            else
                return R.error(511,"表中有相同数据");
        }
    }

}

