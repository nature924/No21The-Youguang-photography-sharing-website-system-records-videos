
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
 * 图片素材
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/sucai")
public class SucaiController {
    private static final Logger logger = LoggerFactory.getLogger(SucaiController.class);

    private static final String TABLE_NAME = "sucai";

    @Autowired
    private SucaiService sucaiService;


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
    private HuodongYuyueService huodongYuyueService;//活动报名
    @Autowired
    private NewsService newsService;//公告资讯
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
        params.put("sucaiDeleteStart",1);params.put("sucaiDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = sucaiService.queryPage(params);

        //字典表数据转换
        List<SucaiView> list =(List<SucaiView>)page.getList();
        for(SucaiView c:list){
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
        SucaiEntity sucai = sucaiService.selectById(id);
        if(sucai !=null){
            //entity转view
            SucaiView view = new SucaiView();
            BeanUtils.copyProperties( sucai , view );//把实体数据重构到view中
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
    public R save(@RequestBody SucaiEntity sucai, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,sucai:{}",this.getClass().getName(),sucai.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<SucaiEntity> queryWrapper = new EntityWrapper<SucaiEntity>()
            .eq("sucai_name", sucai.getSucaiName())
            .eq("sucai_types", sucai.getSucaiTypes())
            .eq("zan_number", sucai.getZanNumber())
            .eq("cai_number", sucai.getCaiNumber())
            .eq("sucai_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        SucaiEntity sucaiEntity = sucaiService.selectOne(queryWrapper);
        if(sucaiEntity==null){
            sucai.setSucaiClicknum(1);
            sucai.setSucaiDelete(1);
            sucai.setInsertTime(new Date());
            sucai.setCreateTime(new Date());
            sucaiService.insert(sucai);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody SucaiEntity sucai, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,sucai:{}",this.getClass().getName(),sucai.toString());
        SucaiEntity oldSucaiEntity = sucaiService.selectById(sucai.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(sucai.getSucaiPhoto()) || "null".equals(sucai.getSucaiPhoto())){
                sucai.setSucaiPhoto(null);
        }
        if("".equals(sucai.getSucaiFile()) || "null".equals(sucai.getSucaiFile())){
                sucai.setSucaiFile(null);
        }

            sucaiService.updateById(sucai);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<SucaiEntity> oldSucaiList =sucaiService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<SucaiEntity> list = new ArrayList<>();
        for(Integer id:ids){
            SucaiEntity sucaiEntity = new SucaiEntity();
            sucaiEntity.setId(id);
            sucaiEntity.setSucaiDelete(2);
            list.add(sucaiEntity);
        }
        if(list != null && list.size() >0){
            sucaiService.updateBatchById(list);
        }

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
            List<SucaiEntity> sucaiList = new ArrayList<>();//上传的东西
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
                            SucaiEntity sucaiEntity = new SucaiEntity();
//                            sucaiEntity.setSucaiUuidNumber(data.get(0));                    //图片素材编号 要改的
//                            sucaiEntity.setSucaiName(data.get(0));                    //图片素材名称 要改的
//                            sucaiEntity.setSucaiPhoto("");//详情和图片
//                            sucaiEntity.setSucaiFile(data.get(0));                    //图片素材 要改的
//                            sucaiEntity.setSucaiTypes(Integer.valueOf(data.get(0)));   //图片素材类型 要改的
//                            sucaiEntity.setSucaiClicknum(Integer.valueOf(data.get(0)));   //图片素材热度 要改的
//                            sucaiEntity.setZanNumber(Integer.valueOf(data.get(0)));   //赞 要改的
//                            sucaiEntity.setCaiNumber(Integer.valueOf(data.get(0)));   //踩 要改的
//                            sucaiEntity.setSucaiContent("");//详情和图片
//                            sucaiEntity.setSucaiDelete(1);//逻辑删除字段
//                            sucaiEntity.setInsertTime(date);//时间
//                            sucaiEntity.setCreateTime(date);//时间
                            sucaiList.add(sucaiEntity);


                            //把要查询是否重复的字段放入map中
                                //图片素材编号
                                if(seachFields.containsKey("sucaiUuidNumber")){
                                    List<String> sucaiUuidNumber = seachFields.get("sucaiUuidNumber");
                                    sucaiUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> sucaiUuidNumber = new ArrayList<>();
                                    sucaiUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("sucaiUuidNumber",sucaiUuidNumber);
                                }
                        }

                        //查询是否重复
                         //图片素材编号
                        List<SucaiEntity> sucaiEntities_sucaiUuidNumber = sucaiService.selectList(new EntityWrapper<SucaiEntity>().in("sucai_uuid_number", seachFields.get("sucaiUuidNumber")).eq("sucai_delete", 1));
                        if(sucaiEntities_sucaiUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(SucaiEntity s:sucaiEntities_sucaiUuidNumber){
                                repeatFields.add(s.getSucaiUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [图片素材编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        sucaiService.insertBatch(sucaiList);
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
    * 个性推荐
    */
    @IgnoreAuth
    @RequestMapping("/gexingtuijian")
    public R gexingtuijian(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("gexingtuijian方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        CommonUtil.checkMap(params);
        List<SucaiView> returnSucaiViewList = new ArrayList<>();

        //查看收藏
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
        PageUtils pageUtils = sucaiCollectionService.queryPage(params1);
        List<SucaiCollectionView> collectionViewsList =(List<SucaiCollectionView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
        for(SucaiCollectionView collectionView:collectionViewsList){
            Integer sucaiTypes = collectionView.getSucaiTypes();
            if(typeMap.containsKey(sucaiTypes)){
                typeMap.put(sucaiTypes,typeMap.get(sucaiTypes)+1);
            }else{
                typeMap.put(sucaiTypes,1);
            }
        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("sucaiTypes",type);
            PageUtils pageUtils1 = sucaiService.queryPage(params2);
            List<SucaiView> sucaiViewList =(List<SucaiView>)pageUtils1.getList();
            returnSucaiViewList.addAll(sucaiViewList);
            if(returnSucaiViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = sucaiService.queryPage(params);
        if(returnSucaiViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnSucaiViewList.size();//要添加的数量
            List<SucaiView> sucaiViewList =(List<SucaiView>)page.getList();
            for(SucaiView sucaiView:sucaiViewList){
                Boolean addFlag = true;
                for(SucaiView returnSucaiView:returnSucaiViewList){
                    if(returnSucaiView.getId().intValue() ==sucaiView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnSucaiViewList.add(sucaiView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnSucaiViewList = returnSucaiViewList.subList(0, limit);
        }

        for(SucaiView c:returnSucaiViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnSucaiViewList);
        return R.ok().put("data", page);
    }

    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = sucaiService.queryPage(params);

        //字典表数据转换
        List<SucaiView> list =(List<SucaiView>)page.getList();
        for(SucaiView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        SucaiEntity sucai = sucaiService.selectById(id);
            if(sucai !=null){

                //点击数量加1
                sucai.setSucaiClicknum(sucai.getSucaiClicknum()+1);
                sucaiService.updateById(sucai);

                //entity转view
                SucaiView view = new SucaiView();
                BeanUtils.copyProperties( sucai , view );//把实体数据重构到view中

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
    public R add(@RequestBody SucaiEntity sucai, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,sucai:{}",this.getClass().getName(),sucai.toString());
        Wrapper<SucaiEntity> queryWrapper = new EntityWrapper<SucaiEntity>()
            .eq("sucai_uuid_number", sucai.getSucaiUuidNumber())
            .eq("sucai_name", sucai.getSucaiName())
            .eq("sucai_types", sucai.getSucaiTypes())
            .eq("sucai_clicknum", sucai.getSucaiClicknum())
            .eq("zan_number", sucai.getZanNumber())
            .eq("cai_number", sucai.getCaiNumber())
            .eq("sucai_delete", sucai.getSucaiDelete())
//            .notIn("sucai_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        SucaiEntity sucaiEntity = sucaiService.selectOne(queryWrapper);
        if(sucaiEntity==null){
            sucai.setSucaiClicknum(1);
                sucai.setZanNumber(1);
                sucai.setCaiNumber(1);
            sucai.setSucaiDelete(1);
            sucai.setInsertTime(new Date());
            sucai.setCreateTime(new Date());
        sucaiService.insert(sucai);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

