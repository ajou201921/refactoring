package ac.kr.ajou.stream;

import lombok.Builder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Builder
public class StreamApi {

    public List<String> filterString(List<String> stringList, String filterString) {
        stringList.stream()
                .filter(string -> string.equals(filterString))
                .collect(Collectors.toList());
        List<String> resultList = new ArrayList<>();
        for (String string : stringList) {
            if (string.equals(filterString)) {
                resultList.add(string);
            }
        }
        return resultList;
    }

    public List<String> filiterByName(List<Person> personList, String filterName) {
       return personList.stream()
                .filter(p -> p.getName().equals(filterName))
                .map(person -> person.getAddress()).collect(Collectors.toList());
    }
    public  int getAggergationAge(List<Person> personList,String filiterName){
        return personList.stream().filter(person -> person.getName().equals(filiterName)).mapToInt(person -> person.getAge()).sum();
    }



}