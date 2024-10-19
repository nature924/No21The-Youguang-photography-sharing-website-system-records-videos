
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
 * 活动
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/huodong")
public class HuodongController {
    private static final Logger logger = LoggerFactory.getLogger(HuodongController.class);

    private static final String TABLE_NAME = "huodong";

    @Autowired
    private HuodongService huodongService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private ForumService forumService;//论坛
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
        params.put("huodongDeleteStart",1);params.put("huodongDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = huodongService.queryPage(params);

        //字典表数据转换
        List<HuodongView> list =(List<HuodongView>)page.getList();
        for(HuodongView c:list){
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
        HuodongEntity huodong = huodongService.selectById(id);
        if(huodong !=null){
            //entity转view
            HuodongView view = new HuodongView();
            BeanUtils.copyProperties( huodong , view );//把实体数据重构到view中
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
    public R save(@RequestBody HuodongEntity huodong, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,huodong:{}",this.getClass().getName(),huodong.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<HuodongEntity> queryWrapper = new EntityWrapper<HuodongEntity>()
            .eq("huodong_name", huodong.getHuodongName())
            .eq("huodong_types", huodong.getHuodongTypes())
            .eq("zan_number", huodong.getZanNumber())
            .eq("cai_number", huodong.getCaiNumber())
            .eq("huodong_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        HuodongEntity huodongEntity = huodongService.selectOne(queryWrapper);
        if(huodongEntity==null){
            huodong.setHuodongClicknum(1);
            huodong.setHuodongDelete(1);
            huodong.setInsertTime(new Date());
            huodong.setCreateTime(new Date());
            huodongService.insert(huodong);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody HuodongEntity huodong, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,huodong:{}",this.getClass().getName(),huodong.toString());
        HuodongEntity oldHuodongEntity = huodongService.selectById(huodong.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(huodong.getHuodongPhoto()) || "null".equals(huodong.getHuodongPhoto())){
                huodong.setHuodongPhoto(null);
        }

            huodongService.updateById(huodong);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<HuodongEntity> oldHuodongList =huodongService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<HuodongEntity> list = new ArrayList<>();
        for(Integer id:ids){
            HuodongEntity huodongEntity = new HuodongEntity();
            huodongEntity.setId(id);
            huodongEntity.setHuodongDelete(2);
            list.add(huodongEntity);
        }
        if(list != null && list.size() >0){
            huodongService.updateBatchById(list);
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
            List<HuodongEntity> huodongList = new ArrayList<>();//上传的东西
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
                            HuodongEntity huodongEntity = new HuodongEntity();
//                            huodongEntity.setHuodongUuidNumber(data.get(0));                    //活动编号 要改的
//                            huodongEntity.setHuodongName(data.get(0));                    //活动标题 要改的
//                            huodongEntity.setHuodongPhoto("");//详情和图片
//                            huodongEntity.setHuodongTypes(Integer.valueOf(data.get(0)));   //活动类型 要改的
//                            huodongEntity.setHuodongClicknum(Integer.valueOf(data.get(0)));   //活动热度 要改的
//                            huodongEntity.setZanNumber(Integer.valueOf(data.get(0)));   //赞 要改的
//                            huodongEntity.setCaiNumber(Integer.valueOf(data.get(0)));   //踩 要改的
//                            huodongEntity.setHuodongContent("");//详情和图片
//                            huodongEntity.setHuodongDelete(1);//逻辑删除字段
//                            huodongEntity.setInsertTime(date);//时间
//                            huodongEntity.setCreateTime(date);//时间
                            huodongList.add(huodongEntity);


                            //把要查询是否重复的字段放入map中
                                //活动编号
                                if(seachFields.containsKey("huodongUuidNumber")){
                                    List<String> huodongUuidNumber = seachFields.get("huodongUuidNumber");
                                    huodongUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> huodongUuidNumber = new ArrayList<>();
                                    huodongUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("huodongUuidNumber",huodongUuidNumber);
                                }
                        }

                        //查询是否重复
                         //活动编号
                        List<HuodongEntity> huodongEntities_huodongUuidNumber = huodongService.selectList(new EntityWrapper<HuodongEntity>().in("huodong_uuid_number", seachFields.get("huodongUuidNumber")).eq("huodong_delete", 1));
                        if(huodongEntities_huodongUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(HuodongEntity s:huodongEntities_huodongUuidNumber){
                                repeatFields.add(s.getHuodongUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [活动编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        huodongService.insertBatch(huodongList);
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
        List<HuodongView> returnHuodongViewList = new ArrayList<>();

        //查看收藏
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
        PageUtils pageUtils = huodongCollectionService.queryPage(params1);
        List<HuodongCollectionView> collectionViewsList =(List<HuodongCollectionView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
        for(HuodongCollectionView collectionView:collectionViewsList){
            Integer huodongTypes = collectionView.getHuodongTypes();
            if(typeMap.containsKey(huodongTypes)){
                typeMap.put(huodongTypes,typeMap.get(huodongTypes)+1);
            }else{
                typeMap.put(huodongTypes,1);
            }
        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("huodongTypes",type);
            PageUtils pageUtils1 = huodongService.queryPage(params2);
            List<HuodongView> huodongViewList =(List<HuodongView>)pageUtils1.getList();
            returnHuodongViewList.addAll(huodongViewList);
            if(returnHuodongViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = huodongService.queryPage(params);
        if(returnHuodongViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnHuodongViewList.size();//要添加的数量
            List<HuodongView> huodongViewList =(List<HuodongView>)page.getList();
            for(HuodongView huodongView:huodongViewList){
                Boolean addFlag = true;
                for(HuodongView returnHuodongView:returnHuodongViewList){
                    if(returnHuodongView.getId().intValue() ==huodongView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnHuodongViewList.add(huodongView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnHuodongViewList = returnHuodongViewList.subList(0, limit);
        }

        for(HuodongView c:returnHuodongViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnHuodongViewList);
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
        PageUtils page = huodongService.queryPage(params);

        //字典表数据转换
        List<HuodongView> list =(List<HuodongView>)page.getList();
        for(HuodongView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        HuodongEntity huodong = huodongService.selectById(id);
            if(huodong !=null){

                //点击数量加1
                huodong.setHuodongClicknum(huodong.getHuodongClicknum()+1);
                huodongService.updateById(huodong);

                //entity转view
                HuodongView view = new HuodongView();
                BeanUtils.copyProperties( huodong , view );//把实体数据重构到view中

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
    public R add(@RequestBody HuodongEntity huodong, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,huodong:{}",this.getClass().getName(),huodong.toString());
        Wrapper<HuodongEntity> queryWrapper = new EntityWrapper<HuodongEntity>()
            .eq("huodong_uuid_number", huodong.getHuodongUuidNumber())
            .eq("huodong_name", huodong.getHuodongName())
            .eq("huodong_types", huodong.getHuodongTypes())
            .eq("huodong_clicknum", huodong.getHuodongClicknum())
            .eq("zan_number", huodong.getZanNumber())
            .eq("cai_number", huodong.getCaiNumber())
            .eq("huodong_delete", huodong.getHuodongDelete())
//            .notIn("huodong_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        HuodongEntity huodongEntity = huodongService.selectOne(queryWrapper);
        if(huodongEntity==null){
            huodong.setHuodongClicknum(1);
                huodong.setZanNumber(1);
                huodong.setCaiNumber(1);
            huodong.setHuodongDelete(1);
            huodong.setInsertTime(new Date());
            huodong.setCreateTime(new Date());
        huodongService.insert(huodong);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

