# DB  
  
  
### Database와 일반 Data의 차이점  
1. 데이터의 중복을 막을 수 있고 자료의 일관성을 유지할 수 있다.  
2. 데이터를 쉽게 검색할 수 있다.  
3. 데이터의 통합이 쉽다.  
4. 여러 사람이 함께 자료를 열람 할 수 있다.  
5. 데이터에 보안을 적용 하기가 쉽다.  
  
  
### 파일 처리 시스템  
1. 데이터가 독립된 별개의 파일에 저장되므로, 데이터의 유지 관리가 어렵다.  
2. 같은 데이터가 여러 개의 파일에 중복되어 있어서 데이터 변경 시 비효율적이다.  
3. 데이터의 형식을 응용 프로그램에서 정의하므로, 데이터 변경 시 프로그램을 변경해야 한다.  
  
  
### 테이블(엔티티)의 구조  
2차원 배열의 형태를 가진다.  
record는 column의 집합.  
table(entity)는 record의 집합.  
database는 계정과 table의 집합.  
field는 column의 값.  
domain은 field의 범위.  
  
  
### SQL 언어의 종류  
1. DQL(Data Query Language)  
데이터 질의어, 데이터 검색, 출력과 관련된 쿼리로 select가 있다.  
  
2. DML(Data Manipulation Language)  
데이터 조작어, 데이터 입력, 수정, 삭제와 관련된 쿼리로 insert, update, delete가 있다.  
  
3. DDL(Data Definition Language)  
데이터 정의어, 테이블 생성 및 삭제, 테이블 구조 수정과 관련된 쿼리로 Create table, drop table, alter table이 있다.  
  
4. TCL(Transaction Control Language)  
트랜잭션 제어 언어, 안정적인 데이터 처리를 위한 데이터 처리와 관련된 명령어로 commit, rollback, savepoint가 있다.  
  
5. DCL(Data Control Language)  
데이터 제어 언어, 권한 부여와 관련된 쿼리로 grant, revoke가 있다.  
  