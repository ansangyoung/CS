# JAVA 프로그래밍 면접 이렇게 준비한다  
  
## 노엘 마크엄 지음  
## 정원천 옮김  
  
  
## 처음 ~ p.49  
이 책은 Java SE 7에 기반을 두고 쓰여졌다. 2015년 1월 자바 최신 버전은 8로, 자바 8에서 주목을 받는 개념을 함께 다루고 있다.  
### 자바 7의 몇 가지 새로운 기능과 API  
1. 다이아몬드 연산자  
컴파일러가 제너릭 인스턴스의 타입을 추측할 수 있다.  
```  
//List<Integer> numbers = new ArrayList<Integer>();  
List<Integer> numbers = new ArrayList<>();  
```  
이렇게 작성하면 컬렉션을 이용할 때 많은 양의 코드를 줄일 수 있다.  
  
2. switch문에서 문자열 사용하기  
숫자타입입만 사용할 수 있었는데, 자바 5에서는 열거형 타입을, 자바 7에서는 문자열 객체를 사용할 수 있도록 발전했다.  
  
  
## p.50 ~ 84  
### 리스트 정렬하기  
Comparable과 Comparator 인터페이스의 차이는 무엇인가?  
- Comparable 인터페이스는 자연스러운 순서로 정렬할 때 사용하고, Comparator는 원하는 대로 정렬 순서를 지정하고 싶은 곳에 사용한다.  

### 정렬 알고리즘  
1. 버블정렬: 역순인 경우 O(n^2), 정렬이 되어있는 경우 O(n)  
2. 삽입정렬: 정렬이 되어 있는 경우 O(n^2), 역순인 경우 O(n)  
3. 퀵정렬: 정렬이 되어 있는 경우 O(n^2), 평균 O(n log n)  
4. 삽입정렬: O(n log n) 보장    
  
  
## p.102 ~ p.108  
소프트웨어 디자인 패턴은 프로그램을 만들면서 발생할 수 있는 다양한 상황에 효율적으로 적용할 수 있는 해결책이다.  
보통 하나 이상의 객체를 함께 사용하며 코드 재사용, 확장성에 초점을 두거나  
앞으로 개발할 때 필요한 견고한 기반을 제공한다는 점에서 디자인 패턴은 알아두면 많은 도움이 된다.  

객체 지향 프로그래밍 언어인 자바는 표준 라이브러리 API를 통해 많은 디자인 패턴을 이용할 수 있게 구성되었다.  

### 빌더 패턴  
빌더 패턴을 사용하면 도메인에 적합한 객체를 생성하는 빌더라는 동반자 객체를 만들 수 있다.  
이것이 생성자를 이용하는 방법보다 더 깔끔하다.  
```  
// 빌더 패턴의 클래스 구현하기  
public class Pet {  
    public static class Builder {  
        private Animal animal;  
        private String perName;  
        
        public Builder withAnimal(final Animal animal) {  
            this.animal = animal;  
            return this;  
        }  
        
        public Builder withPetName(final String petName) {  
            this.petName = petName;  
            return this;  
        }  
        
        public Pet build() {  
            return new Pet(anial, petName);  
        }  
    }  
    
    private final Animal animal;  
    private final String petName;  
    
    private Pet(final Animal animal, final String petName) {  
        this.animal = animal;  
        this.petName = petName;  
    }  
}  
  
  
// 빌더 패턴으로 객체 생성하기  
@Test  
public void legalBuild() {  
    final Pet.Builder builder = new Pet.Builder();  
    final Pet pet = builder  
        .withAnimal(Animal.Cat)  
        .withPetName("Squidge")  
        .build();  
    // 예외 처리 없이 테스트가 통과함  
}  
```  
Builder 클래스는 Pet 클래스의 일부이며 Pet 객체를 생성하는 전적인 권한이 있다.  
각 매개변수에 명시적인 메서드가 있다면 각 값을 정확히 어떻게 사용하는지 이해하기도 쉽고,  
순서에 상관없이 호출하고 싶은 데로 호출할 수도 있다.  
(Build 메서드가 이런 명시적인 메서드 역할을 한다.)  
즉, Pet 객체의 실제 생성자를 호출해서 실제 Pet 객체를 반환한다.  
생성자는 이제 final 키워드를 뺀 private으로 선언할 수 있다.  