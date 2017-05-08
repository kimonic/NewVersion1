package dingw.com.newversion.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import dingw.com.newversion.fragment.wait.ConsultantUNdoneFragment;
import dingw.com.newversion.fragment.wait.EMailFragment;
import dingw.com.newversion.fragment.wait.FeiYIPiBanFragment;
import dingw.com.newversion.fragment.wait.FinancingFragment;
import dingw.com.newversion.fragment.wait.NetizenConsultFragment;
import dingw.com.newversion.fragment.wait.NewLawExpressFragment;
import dingw.com.newversion.fragment.wait.NewsFragment;
import dingw.com.newversion.fragment.wait.NoticeFragment;
import dingw.com.newversion.fragment.wait.YiPiBanFragment;
import dingw.com.newversion.fragment.work.LawsuitFragment;
import dingw.com.newversion.fragment.work.NoLawsuitFragment;
import dingw.com.newversion.fragment.work.NoPiBanFragment;
import dingw.com.newversion.fragment.work.PiBanFragment;

/**
 * Created by 12348 on 2017/5/3 0003.
 * fragment集合生产类
 */

public class FragmentFactory {
    private int[] fragmentType;
    private Fragment fragment;

    public FragmentFactory(int[] fragmentType) {
        this.fragmentType = fragmentType;
    }
    /**取得要加载的fragment集合*/
    public List<Fragment> getFragmentList(){
        List<Fragment> list=new ArrayList<>();

        if (fragmentType.length>0){
           for(int i:fragmentType){
                list.add(getFragment(i));
            }
        }
        return list;
    }
    /**取得fragment实例*/
    private Fragment getFragment(int type) {

        switch (type){
            case 0:
                fragment=new NoContentFragment();
                break;
            case 1:
                fragment=new FinancingFragment();
                break;
//            case 2:
//                fragment =new Fragment_Test();
//                break;
//            case 3://平台--案件进度fragment
//                fragment=new FragmentCasePlan();
//                break;
//            case 4://平台--法律计算器
//                fragment=new FragmentLawCalculator();
//                break;
//
//            case 5://平台--法律计算器--诉讼费计算器fragment
//                createCalculatorFrag("http://share.12348flfw.com/tool/susongfei.html");
//                break;
//            case 6://平台--法律计算器--律师费计算器fragment
//                createCalculatorFrag("http://share.12348flfw.com/tool/lvshifei.html");
//                break;
//            case 7://平台--法律计算器--银行贷款利息计算器
//                createCalculatorFrag("http://share.12348flfw.com/tool/yinhangfei.html");
//                break;
//            case 8://平台--法律计算器--财产保全案件计算器
//                createCalculatorFrag("http://share.12348flfw.com/tool/baoquan.html");
//
//                break;
//
//
//            case 9://平台--法律计算器--执行费计算器
//                createCalculatorFrag("http://share.12348flfw.com/tool/zhixing.html");
//                break;
//            case 10://平台--法律计算器--医保计算器
//                createCalculatorFrag("http://share.12348flfw.com/tool/yibao.html");
//                break;
//            case 11://平台--法律计算器--日期计算器
//                createCalculatorFrag("http://share.12348flfw.com/tool/riqi.html");
//                break;
//
//
//            case 12://平台--法律计算器--延迟利息计算器
//                createCalculatorFrag("http://share.12348flfw.com/tool/yanchi.html");
//                break;
//            case 13://平台--法律计算器--违约金计算器
//                createCalculatorFrag("http://share.12348flfw.com/tool/weiyue.html");
//                break;
//            case 14://平台--法律计算器--人身损害赔偿计算器
//                createCalculatorFrag("http://share.12348flfw.com/tool/renshen.html");
//                break;
//
//
//            case 15://平台--法律计算器--拍卖佣金计算器
//                createCalculatorFrag(" http://share.12348flfw.com/tool/paimai.html");
//                break;
//            case 16://平台--法律计算器--司法鉴定费计算器
//                createCalculatorFrag(" http://share.12348flfw.com/tool/sifa.html");
//                break;
//            case 17://平台--法律计算器--仲裁费用计算器
//                createCalculatorFrag("http://share.12348flfw.com/tool/zhongcai.html");
//                break;
//
//
//
//            case 18://平台--法律计算器--房屋还贷计算器
//                createCalculatorFrag("http://share.12348flfw.com/tool/fangdai.html");
//                break;
//            case 19://平台--法律计算器--离婚房产分割计算器
//                createCalculatorFrag("http://share.12348flfw.com/tool/lihun.html");
//                break;
//            case 20://平台--法律计算器--拆迁补偿计算器
//                createCalculatorFrag(" http://share.12348flfw.com/tool/chaiqian.html");
//                break;
//
//
//
//            case 21://平台--法律计算器--征地补偿计算器
//                createCalculatorFrag("http://share.12348flfw.com/tool/zhengdi.html");
//                break;
//            case 22://平台--法律计算器--法律法规信息查询
//                createCalculatorFrag("http://search.chinalaw.gov.cn/search2.html");
//                break;
//            case 23://平台--法律计算器--裁判文书信息查询
//                createCalculatorFrag("http://www.court.gov.cn/wenshu.html");
//                break;
//
//
//
//            case 24://平台--法律计算器--专利信息查询
//                createCalculatorFrag("http://cpquery.sipo.gov.cn/txnDisclaimerDetail.do?time=1483950498919&select-key:yuzhong=zh&select-key:gonggaolx=3");
//                break;
//            case 25://平台--法律计算器--学位证书查询
//                createCalculatorFrag("http://www.chinadegrees.com.cn/");
//                break;
//            case 26://平台--法律计算器--组织机构信息查询
//                createCalculatorFrag( "http://www.nacao.org.cn/");
//                break;
//
//
//            case 27://平台--法律计算器--失信执行人查询
//                createCalculatorFrag("http://shixin.court.gov.cn/");
//                break;
//            case 28://平台--法律计算器--被执行人信息查询
//                createCalculatorFrag("http://zhixing.court.gov.cn/search/");
//                break;
//            case 29://平台--法律计算器--土地证书编号查询
//                createCalculatorFrag("http://www.rerc.com.cn/ts01.htm");
//                break;
            case 30://工作--本所公告--
//                fragment=new FragmentNotice();
                createNoticeFrag("http://ceshi.12348oa.com/flfw/bulletin/getList?page=",1);
                break;
//            case 31://工作--会议记录
//                createNoticeFrag("http://ceshi.12348oa.com/flfw/minute/getList?page=",2);
//                break;
            case 32://待办--案件--诉讼案件--已批办
                fragment= new YiPiBanFragment();
                break;
            case 33://待办--案件--a非诉讼案件--已批办
                fragment=new FeiYIPiBanFragment();
                break;
            case 34://待办--顾问--未完成工单
                fragment=new ConsultantUNdoneFragment();
                break;
            case 35://待办--网民咨询
                fragment=new NetizenConsultFragment();
                break;
            case 36://待办 --新法速递
                fragment=new NewLawExpressFragment();
                break;
            case 37://主页--工作--诉讼案件
                fragment=new LawsuitFragment();
                break;
            case 38://主页--工作--非诉讼案件
                fragment=new NoLawsuitFragment();
                break;
            case 39://主页--工作--我要批办
                fragment=new PiBanFragment();
                break;
            case 40://主页--工作--我要批办--非诉讼批办--已批办
                fragment=new NoPiBanFragment();
                break;
//            case 41://主页--工作--顾问单位
//                fragment=new FragmentConsultantUnit();
//                break;
//            case 42://主页--工作--我的财务
//                fragment=new FragmentMyFinancing();
//                break;
//            case 43://工作--提现管理--审核中
//                fragment=new FragmentWithdraws();
//                break;
//            case 44://工作--提现管理--已提取
//                fragment=new FragmentWithdraws();
//                Bundle bundle=new Bundle();
//                bundle.putInt("type",2);
//                fragment.setArguments(bundle);
//                break;
//            case 45://工作--押金管理--审核中
//                createDepositFragment(1);
//                break;
//            case 46://工作--押金管理--已审核
//                createDepositFragment(2);
//                break;
//            case 47://工作--押金管理--已提取
//                createDepositFragment(3);
//                break;
//            case 48://工作--其他费用
//                fragment=new FragmnetOtherCost();
//                break;
//            case 49://平台--网民委托--已联系--委托详情
//                createNetizenEntrustFragment(1);
//                break;
//            case  50://平台--网民委托--已完成--委托详情
//                createNetizenEntrustFragment(2);
//                break;
//            case 51://主页--平台--委托订单fragment
//                createEntrustIndentFragment(1);
//                break;
//            case 52://主页--平台--委托订单fragment
//                createEntrustIndentFragment(2);
//                break;
//            case 53://主页--平台--法律服务招投标管理
//                fragment=new FragmentZhaoTouBiao();
//                break;
//            case 54://主页--平台--合同范本
//                fragment=new FragmentContractModel();
//                break;
//            case 55://主页--平台--文书
//                fragment=new FragmentWenShu();
//                break;
            case 56://主页--待办--email点击--通知
                fragment=new EMailFragment();
                break;
            case 57://主页--待办--email点击--消息
                fragment=new NewsFragment();
                break;
//            case 58:break;
//            case 59:break;
//            case 60:break;
        }
        return fragment;
    }
//    /**创建委托订单fragment*/
//    private void createEntrustIndentFragment(int type) {
//        fragment=new FragmentEntrustIndent();
//        Bundle bundle=new Bundle();
//        bundle.putInt("type",type);
//        fragment.setArguments(bundle);
//    }
//
//    /**创建网民委托fragment*/
//    private void createNetizenEntrustFragment(int type) {
//        fragment=new FragmentNetizenEntrust();
//        Bundle bundle=new Bundle();
//        bundle.putInt("type",type);
//        fragment.setArguments(bundle);
//
//    }
//    /**创建押金管理fragment*/
//    private void createDepositFragment(int type) {
//        fragment=new FragmentDeposit();
//        Bundle bundle=new Bundle();
//        bundle.putInt("type",type);
//        fragment.setArguments(bundle);
//    }
    /**创建本所公告fragment*/
    private void createNoticeFrag(String url,int type) {
        fragment=new NoticeFragment();
        Bundle bundle=new Bundle();
        bundle.putString("url",url);
        bundle.putInt("type",type);
        fragment.setArguments(bundle);
    }
//    /**创建计算器fragment*/
//    private void createCalculatorFrag(String url) {
//        fragment=new FragmentCalculator();
//        Bundle bundle=new Bundle();
//        bundle.putString("url",url);
//        fragment.setArguments(bundle);
//    }
}
