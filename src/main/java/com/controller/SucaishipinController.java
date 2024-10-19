
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
 * 视频素材
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/sucaishipin")
public class SucaishipinController {
    private static final Logger logger = LoggerFactory.getLogger(SucaishipinController.class);

    private static final String TABLE_NAME = "sucaishipin";

    @Autowired
    private SucaishipinService sucaishipinService;


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
    private SucaiService sucaiService;//图片素材
    @Autowired
    private SucaiCollectionService sucaiCollectionService;//图片素材收藏
    @Autowired
    private SucaiLiuyanService sucaiLiuyanService;//图片素材留言
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
        params.put("sucaishipinDeleteStart",1);params.put("sucaishipinDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = sucaishipinService.queryPage(params);

        //字典表数据转换
        List<SucaishipinView> list =(List<SucaishipinView>)page.getList();
        for(SucaishipinView c:list){
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
        SucaishipinEntity sucaishipin = sucaishipinService.selectById(id);
        if(sucaishipin !=null){
            //entity转view
            SucaishipinView view = new SucaishipinView();
            BeanUtils.copyProperties( sucaishipin , view );//把实体数据重构到view中
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
    public R save(@RequestBody SucaishipinEntity sucaishipin, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,sucaishipin:{}",this.getClass().getName(),sucaishipin.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<SucaishipinEntity> queryWrapper = new EntityWrapper<SucaishipinEntity>()
            .eq("sucaishipin_name", sucaishipin.getSucaishipinName())
            .eq("sucaishipin_video", sucaishipin.getSucaishipinVideo())
            .eq("sucaishipin_types", sucaishipin.getSucaishipinTypes())
            .eq("zan_number", sucaishipin.getZanNumber())
            .eq("cai_number", sucaishipin.getCaiNumber())
            .eq("sucaishipin_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        SucaishipinEntity sucaishipinEntity = sucaishipinService.selectOne(queryWrapper);
        if(sucaishipinEntity==null){
            sucaishipin.setSucaishipinClicknum(1);
            sucaishipin.setSucaishipinDelete(1);
            sucaishipin.setInsertTime(new Date());
            sucaishipin.setCreateTime(new Date());
            sucaishipinService.insert(sucaishipin);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody SucaishipinEntity sucaishipin, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,sucaishipin:{}",this.getClass().getName(),sucaishipin.toString());
        SucaishipinEntity oldSucaishipinEntity = sucaishipinService.selectById(sucaishipin.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(sucaishipin.getSucaishipinPhoto()) || "null".equals(sucaishipin.getSucaishipinPhoto())){
                sucaishipin.setSucaishipinPhoto(null);
        }
        if("".equals(sucaishipin.getSucaishipinVideo()) || "null".equals(sucaishipin.getSucaishipinVideo())){
                sucaishipin.setSucaishipinVideo(null);
        }
        if("".equals(sucaishipin.getSucaishipinFile()) || "null".equals(sucaishipin.getSucaishipinFile())){
                sucaishipin.setSucaishipinFile(null);
        }

            sucaishipinService.updateById(sucaishipin);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<SucaishipinEntity> oldSucaishipinList =sucaishipinService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<SucaishipinEntity> list = new ArrayList<>();
        for(Integer id:ids){
            SucaishipinEntity sucaishipinEntity = new SucaishipinEntity();
            sucaishipinEntity.setId(id);
            sucaishipinEntity.setSucaishipinDelete(2);
            list.add(sucaishipinEntity);
        }
        if(list != null && list.size() >0){
            sucaishipinService.updateBatchById(list);
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
            List<SucaishipinEntity> sucaishipinList = new ArrayList<>();//上传的东西
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
                            SucaishipinEntity sucaishipinEntity = new SucaishipinEntity();
//                            sucaishipinEntity.setSucaishipinUuidNumber(data.get(0));                    //视频素材编号 要改的
//                            sucaishipinEntity.setSucaishipinName(data.get(0));                    //视频素材名称 要改的
//                            sucaishipinEntity.setSucaishipinPhoto("");//详情和图片
//                            sucaishipinEntity.setSucaishipinVideo(data.get(0));                    //视频 要改的
//                            sucaishipinEntity.setSucaishipinFile(data.get(0));                    //视频素材 要改的
//                            sucaishipinEntity.setSucaishipinTypes(Integer.valueOf(data.get(0)));   //视频素材类型 要改的
//                            sucaishipinEntity.setSucaishipinClicknum(Integer.valueOf(data.get(0)));   //视频素材热度 要改的
//                            sucaishipinEntity.setZanNumber(Integer.valueOf(data.get(0)));   //赞 要改的
//                            sucaishipinEntity.setCaiNumber(Integer.valueOf(data.get(0)));   //踩 要改的
//                            sucaishipinEntity.setSucaishipinContent("");//详情和图片
//                            sucaishipinEntity.setSucaishipinDelete(1);//逻辑删除字段
//                            sucaishipinEntity.setInsertTime(date);//时间
//                            sucaishipinEntity.setCreateTime(date);//时间
                            sucaishipinList.add(sucaishipinEntity);


                            //把要查询是否重复的字段放入map中
                                //视频素材编号
                                if(seachFields.containsKey("sucaishipinUuidNumber")){
                                    List<String> sucaishipinUuidNumber = seachFields.get("sucaishipinUuidNumber");
                                    sucaishipinUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> sucaishipinUuidNumber = new ArrayList<>();
                                    sucaishipinUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("sucaishipinUuidNumber",sucaishipinUuidNumber);
                                }
                        }

                        //查询是否重复
                         //视频素材编号
                        List<SucaishipinEntity> sucaishipinEntities_sucaishipinUuidNumber = sucaishipinService.selectList(new EntityWrapper<SucaishipinEntity>().in("sucaishipin_uuid_number", seachFields.get("sucaishipinUuidNumber")).eq("sucaishipin_delete", 1));
                        if(sucaishipinEntities_sucaishipinUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(SucaishipinEntity s:sucaishipinEntities_sucaishipinUuidNumber){
                                repeatFields.add(s.getSucaishipinUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [视频素材编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        sucaishipinService.insertBatch(sucaishipinList);
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
        List<SucaishipinView> returnSucaishipinViewList = new ArrayList<>();

        //查看收藏
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
        PageUtils pageUtils = sucaishipinCollectionService.queryPage(params1);
        List<SucaishipinCollectionView> collectionViewsList =(List<SucaishipinCollectionView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
        for(SucaishipinCollectionView collectionView:collectionViewsList){
            Integer sucaishipinTypes = collectionView.getSucaishipinTypes();
            if(typeMap.containsKey(sucaishipinTypes)){
                typeMap.put(sucaishipinTypes,typeMap.get(sucaishipinTypes)+1);
            }else{
                typeMap.put(sucaishipinTypes,1);
            }
        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("sucaishipinTypes",type);
            PageUtils pageUtils1 = sucaishipinService.queryPage(params2);
            List<SucaishipinView> sucaishipinViewList =(List<SucaishipinView>)pageUtils1.getList();
            returnSucaishipinViewList.addAll(sucaishipinViewList);
            if(returnSucaishipinViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = sucaishipinService.queryPage(params);
        if(returnSucaishipinViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnSucaishipinViewList.size();//要添加的数量
            List<SucaishipinView> sucaishipinViewList =(List<SucaishipinView>)page.getList();
            for(SucaishipinView sucaishipinView:sucaishipinViewList){
                Boolean addFlag = true;
                for(SucaishipinView returnSucaishipinView:returnSucaishipinViewList){
                    if(returnSucaishipinView.getId().intValue() ==sucaishipinView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnSucaishipinViewList.add(sucaishipinView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnSucaishipinViewList = returnSucaishipinViewList.subList(0, limit);
        }

        for(SucaishipinView c:returnSucaishipinViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnSucaishipinViewList);
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
        PageUtils page = sucaishipinService.queryPage(params);

        //字典表数据转换
        List<SucaishipinView> list =(List<SucaishipinView>)page.getList();
        for(SucaishipinView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        SucaishipinEntity sucaishipin = sucaishipinService.selectById(id);
            if(sucaishipin !=null){

                //点击数量加1
                sucaishipin.setSucaishipinClicknum(sucaishipin.getSucaishipinClicknum()+1);
                sucaishipinService.updateById(sucaishipin);

                //entity转view
                SucaishipinView view = new SucaishipinView();
                BeanUtils.copyProperties( sucaishipin , view );//把实体数据重构到view中

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
    public R add(@RequestBody SucaishipinEntity sucaishipin, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,sucaishipin:{}",this.getClass().getName(),sucaishipin.toString());
        Wrapper<SucaishipinEntity> queryWrapper = new EntityWrapper<SucaishipinEntity>()
            .eq("sucaishipin_uuid_number", sucaishipin.getSucaishipinUuidNumber())
            .eq("sucaishipin_name", sucaishipin.getSucaishipinName())
            .eq("sucaishipin_video", sucaishipin.getSucaishipinVideo())
            .eq("sucaishipin_types", sucaishipin.getSucaishipinTypes())
            .eq("sucaishipin_clicknum", sucaishipin.getSucaishipinClicknum())
            .eq("zan_number", sucaishipin.getZanNumber())
            .eq("cai_number", sucaishipin.getCaiNumber())
            .eq("sucaishipin_delete", sucaishipin.getSucaishipinDelete())
//            .notIn("sucaishipin_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        SucaishipinEntity sucaishipinEntity = sucaishipinService.selectOne(queryWrapper);
        if(sucaishipinEntity==null){
            sucaishipin.setSucaishipinClicknum(1);
                sucaishipin.setZanNumber(1);
                sucaishipin.setCaiNumber(1);
            sucaishipin.setSucaishipinDelete(1);
            sucaishipin.setInsertTime(new Date());
            sucaishipin.setCreateTime(new Date());
        sucaishipinService.insert(sucaishipin);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

