package dingw.com.newversion.bean.work;

import java.util.List;

/**
 * Created by 12348 on 2017/5/10 0010.
 * 主页--工作--我的财务gsonbean
 */

public class FinanceBean {

    /**
     * state : 200
     * year : 2017
     * my_statistics : {"amount":"29122","arrival_amount":"23122","non_amount":"6000"}
     * other_statistics : {"amount":"-66954","expenditure":"67598","income":"644"}
     * foregif_statistics : {"amount":103,"arrival_amount":"100","non_amount":"3"}
     * years : ["2015","2016","2017"]
     */

    private String state;
    private String year;
    private MyStatisticsBean my_statistics;
    private OtherStatisticsBean other_statistics;
    private ForegifStatisticsBean foregif_statistics;
    private List<String> years;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public MyStatisticsBean getMy_statistics() {
        return my_statistics;
    }

    public void setMy_statistics(MyStatisticsBean my_statistics) {
        this.my_statistics = my_statistics;
    }

    public OtherStatisticsBean getOther_statistics() {
        return other_statistics;
    }

    public void setOther_statistics(OtherStatisticsBean other_statistics) {
        this.other_statistics = other_statistics;
    }

    public ForegifStatisticsBean getForegif_statistics() {
        return foregif_statistics;
    }

    public void setForegif_statistics(ForegifStatisticsBean foregif_statistics) {
        this.foregif_statistics = foregif_statistics;
    }

    public List<String> getYears() {
        return years;
    }

    public void setYears(List<String> years) {
        this.years = years;
    }

    public static class MyStatisticsBean {
        /**
         * amount : 29122
         * arrival_amount : 23122
         * non_amount : 6000
         */

        private String amount;
        private String arrival_amount;
        private String non_amount;

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getArrival_amount() {
            return arrival_amount;
        }

        public void setArrival_amount(String arrival_amount) {
            this.arrival_amount = arrival_amount;
        }

        public String getNon_amount() {
            return non_amount;
        }

        public void setNon_amount(String non_amount) {
            this.non_amount = non_amount;
        }
    }

    public static class OtherStatisticsBean {
        /**
         * amount : -66954
         * expenditure : 67598
         * income : 644
         */

        private String amount;
        private String expenditure;
        private String income;

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getExpenditure() {
            return expenditure;
        }

        public void setExpenditure(String expenditure) {
            this.expenditure = expenditure;
        }

        public String getIncome() {
            return income;
        }

        public void setIncome(String income) {
            this.income = income;
        }
    }

    public static class ForegifStatisticsBean {
        /**
         * amount : 103
         * arrival_amount : 100
         * non_amount : 3
         */

        private String amount;
        private String arrival_amount;
        private String non_amount;

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getArrival_amount() {
            return arrival_amount;
        }

        public void setArrival_amount(String arrival_amount) {
            this.arrival_amount = arrival_amount;
        }

        public String getNon_amount() {
            return non_amount;
        }

        public void setNon_amount(String non_amount) {
            this.non_amount = non_amount;
        }
    }
}
