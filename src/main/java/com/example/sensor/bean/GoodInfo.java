package com.example.sensor.bean;

import com.example.sensor.R;

import java.util.ArrayList;

public class GoodInfo {
    public long rowid;
    public int xuhao;
    public String name;
    public String desc;
    public float price;
    public String thumb_path;
    public String pic_path;
    public int thumb;
    public int pic;

    public GoodInfo(){
        rowid = 0L;
        xuhao = 0;
        name = "";
        desc = "";
        price = 0;
        thumb_path = "";
        pic = 0;
        pic_path = "";
        thumb = 0;
    }

    private static String[] mNameArray ={"iPhone 8","Mate 10","MI 8","OPPO R11",
    "vivo X9s","MEIZU Pro6s"};
    private static String[] mDescArray = {
            "Apple iPhone 8 256GB 玫瑰金色 移动联通电信4G手机",
            "华为 HUAWEI Mate10 6GB+128GB 全网通（香槟金）",
            "小米 MI6 全网通版 6GB+128GB 亮白色",
            "OPPO R11 4G+64G 全网通4G智能手机 玫瑰金",
            "vivo X9s 4GB+64GB 全网通4G拍照手机 玫瑰金",
            "魅族 PRO6S 4GB+64GB 全网通公开版 星空黑 移动联通电信4G手机"
    };
    private static float[] mPricArray = {6999,3999,2999,2699,2399,2099};
    private static int[] mThumArray = {
            R.drawable.iphone_s,R.drawable.huawei_s,R.drawable.xiaomi_s,R.drawable.oppo_s,
            R.drawable.vivo_s,R.drawable.meizu_s
    };
    private static int[] mPicArray = {R.drawable.iphone,R.drawable.huawei,R.drawable.xiaomi,R.drawable.oppo,
            R.drawable.vivo,R.drawable.meizu};

    public static ArrayList<GoodInfo> getGoodList(){
        ArrayList<GoodInfo> arrayList = new ArrayList<>();
        for (int i = 0; i < mThumArray.length;i ++){
            GoodInfo goodInfo = new GoodInfo();
            goodInfo.name = mNameArray[i];
            goodInfo.desc = mDescArray[i];
            goodInfo.price = mPricArray[i];
            goodInfo.thumb = mThumArray[i];
            goodInfo.pic = mPicArray[i];
            arrayList.add(goodInfo);
        }
        return arrayList;
    }

}
