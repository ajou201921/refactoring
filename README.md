기존의 dirty code를 분석해본 결과
4가지 종류의 아이템이 있고 그 아이템들이 서로 다른 조건으로 퀄리티와 셀린이 변한다는 것을 찾아내었다. 
따라서 아이템의 종류 별로 나누어 리펙토링을 하는 것이 가장 적합해 보였다. 또한 중복된 코드를 메소드로 만들어서 코드가 간결하게 만들었다. 메소드가 어떻게 사용되는지 직관적으로 이해하기 쉽도록 메소드 이름을 설정하였다. update quality  메소드에서 메소드의 이름과 맞지 않는 Sellin을 변경하는 메소드를 분리하였고 Dirty code 클래스의 책임을 줄여주기 위해 Sellin을 줄여주는 메소드를 item 클래스로 옮겨주었다.
1. 아이템 name이 A(Aged Brie) 일 때
quality가 50보다 작으면 quality를 1 증가시킨다.
또한 quality의 값과는 무관하게 그 아이템의 sellin value를 1 감소시킨다. 

그리고 변경된 sellin가 0보다 작을 때  quality가 50보다 작으면 quality를 1 증가시킨다.

2. 아이템 name이 B(Backstage passes to a TAFKAL80ETC concert) 일 때
quality가 50보다 작으면 quality을 1 증가시킨다.

sellin 이 11보다 작고 바뀐 quality가 50보다 작으면 quality를 1 증가시킨다

sellin 6보다 작고  바뀐 quality가 50보다 작으면  quality를 1 증가시킨다

그리고 sellin을 1 감소시킨다

바뀐 sellin이 0보다 작을 때, quality를 0으로 초기화한다. 

3. 아이템 name이 C(Sulfuras, Hand of Ragnaros) 일 때
Quality과 sellin이 변경되지 않는다. 

4. 제외한 다른 아이템

Quality가 0보다 크면 quality를 1 감소시킨다 
그리고 sellin을 1 감소시킨다

바뀐 sellin이 0보다 작을 때
quality가 0보다 크면 quality를 1 감소시킨다 

이와 같이 4개로 분류하였고 위의 조건에 맞춰서 각 아이템별로 새로 만든 method가 제대로 기능하는지 확인하기 위해서 테스트를 실시하였다.
