package level1;

import java.util.*;

public class 개인정보수집유효기간 {
    static class Date{
        String kind;
        int year, month, day;

        public Date(String kind, int year, int month, int day){
            this.kind = kind;
            this.year = year;
            this.month = month;
            this.day = day;
        }
    }
    public static void main(String[] args){
        String[] terms1 = {"A 6", "B 12", "C 3"};
        String[] privacies1 = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
        System.out.println(Arrays.toString(solution("2022.05.19", terms1, privacies1))); //[1, 3]
    }

    public static int[] solution(String today, String[] terms, String[] privacies) {
        // today 파싱
        String[] today_arr = today.split("\\.");
        int today_year = Integer.parseInt(today_arr[0]);
        int today_month = Integer.parseInt(today_arr[1]);
        int today_day = Integer.parseInt(today_arr[2]);

        HashMap<String, Integer> termsMap = new HashMap<>();
        List<Date> privaciesList = new ArrayList<>();

        // terms 파싱
        StringTokenizer st;
        for (int i = 0; i < terms.length; i++) {
            st = new StringTokenizer(terms[i]);
            String kindKey = st.nextToken();
            String temp_terms = st.nextToken();

            termsMap.put(kindKey , Integer.parseInt(temp_terms));
        }


        // privacies 파싱
        for(int i = 0 ; i < privacies.length; i++){
            st = new StringTokenizer(privacies[i]);
            String date_temp = st.nextToken();
            String kind_temp = st.nextToken();
            String[] date_arr_temp = date_temp.split("\\.");
            int year_temp = Integer.parseInt(date_arr_temp[0]);
            int month_temp = Integer.parseInt(date_arr_temp[1]);
            int day_temp = Integer.parseInt(date_arr_temp[2]);

            privaciesList.add(new Date(kind_temp, year_temp, month_temp, day_temp));
        }

        List<Integer> result = new ArrayList<>();
        int count = 1;
        // privacies 마다 비교하며 파기 정보 수집
        for( Date d : privaciesList ){
            int term = termsMap.get(d.kind);
            int privaciesYear = d.year;
            int privaciesMonth = d.month + term;
            int privaciesDay = d.day;

            if(privaciesMonth >= 13){
                privaciesYear += privaciesMonth / 12;
                if(privaciesMonth % 12 == 0 ){
                    privaciesMonth = 12;
                    privaciesYear -= 1;

                }else{
                    privaciesMonth = privaciesMonth % 12;
                }
            }
            privaciesDay -= 1;
            if(privaciesDay == 0){
                privaciesDay = 28;
                privaciesMonth -= 1;
                if(privaciesMonth == 0){
                    privaciesYear -= 1;
                    privaciesMonth = 12;
                }
            }


            if(today_year > privaciesYear){
                result.add(count);
            }
            if(today_year == privaciesYear){
                if(today_month > privaciesMonth){
                    result.add(count);
                }
                if(today_month == privaciesMonth){
                    if(today_day > privaciesDay){
                        result.add(count);
                    }
                }
            }

            count++;
        }

        int[] answer = new int[result.size()];
        for(int i =0 ; i < answer.length; i++){
            answer[i] = result.get(i);
        }

        return answer;
    }
}
