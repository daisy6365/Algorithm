import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

// Hash에 대해 공부
/*
* ArrayList : 내부 인덱스를 이용 -> 빠른 검색 BUT 데이터의 추가/삭제시 많은 시간이 소요
* LinkedList : 인근 노드들의 참조값만 수정 -> 빠른 처리 BUT 순회 검색으로 인해 효율이 떨어지는 구조
*
* Hash
* - 내부 배열을 사용 -> 빠른 검색
* - 데이터와 연관된 고유한 숫자를 만들어 낸 뒤 이를 인덱스로 사용
*
* <Collection>
* SET (집합)
* HashSet : 중복을 허용하지 않는다. 또한, 순서를 가지지 않음
* LinkedHashSet : 중복은 허용하지 않지만, 순서를 가짐
* TreeSet : 중복은 허용하지 않지만, Tree를 사용해 데이터를 알아서 정렬
*
* MAP (Key, Value를 가짐)
* HashMap : 내부 hash 값에 따라서 키순서가 정해지므로 특정 규칙없이 출력
* TreeMap : 트리에 저장되므로 키값은 일정 기준으로 정렬된 상태로 출력
* LinkedHashMap : 키값은 입력 순서대로 출력
* Hashtable : HashMap과 같지만 Thread-Safe하여 동기화를 지원
* */
public class BOJ_13414_수강신청 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int people = Integer.parseInt(st.nextToken());
        // 중복 허용 X , 대기순서가 있으므로 순서가져야함 -> LinkedHashSet 사용
        LinkedHashSet<String> hashSet = new LinkedHashSet<>();
        for (int i = 0; i < people ; i++) {
            String student_id = br.readLine();
            if(hashSet.contains(student_id)) hashSet.remove(student_id);
            hashSet.add(student_id);
        }

        int i = 0;
        for (String s: hashSet) {
            if(i == N) return;
            System.out.println(s);
            i++;
        }
    }
}
