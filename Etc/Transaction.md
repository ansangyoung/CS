# Transaction  
insert, update, delete 등 DB 변경에 해당하는 명령이 있는 SQL 구문을 트랜잭션이라고 한다.  
트랜잭션 처리가 필요한 예로 계좌이체 과정이 있다.  


### 기본 개념  
1. 원자성  
트랜잭션 내에 있는 모든 작업이 완료되거나 모든 작업이 완료되지 않아야 한다.  
2. 일관성  
트랜잭션 중에 오류 없이 유효한 데이터만 데이터베이스에 저장되어야 한다.  
3. 격리성  
트랜잭션 중에 변경된 내용이 트랜잭션이 완료되기 전까지 다른 트랜잭션에 영향을 미쳐서는 안된다.  
4. 지속성  
트랜잭션이 완료된 경우 시스템 고장이나 네트워크 에러 등으로 데이터가 유실되지 않고 정상적으로 기록되어야 한다.  
  
  
### 자바의 경우  
<pre><code>    
private Connection con;  
con = DriverManager.getConnection(url, id, pwd);  
con.setAutoCommit(false);  
</code></pre>  
처럼 커밋을 위임하지 않고 사용자가 정의 하려면 false를 넘겨줄 수 있다. 주의사항으로 디폴트는 ``autocommit(true);`` 이며, false로 선언한 후 작업이 완료되면 자동위탁모드를 다시 true로 바꿔야 한다. catch 구문에서 rollback을 호출하여 Connection 객체가 현재 보관 유지하는 데이터베이스 락을 해제해야 한다.  


### 스프링의 경우  
@Transactional 어노테이션이 클래스 위에 추가되면, 이 클래스에 트랜잭션 기능이 적용된 프록시 객체가 생성된다. 이 프록시 객체는 어노테이션이 포함된 메소드가 호출 될 경우, PlatformTransactionManager를 사용하여 트랜잭션을 시작하고, 정상 여부에 따라 Commit, 또는 Rollback 처리를 자동 수행해준다.


### 참고  
1. [자바 트랜잭션 java transaction 설명 개념 / 방법 처리](http://blog.naver.com/PostView.nhn?blogId=0131v&logNo=110105753252&parentCategoryNo=35&viewDate=&currentPage=1&listtype=0)  
2. [@Transactional 정리 및 예제](https://goddaehee.tistory.com/167)
