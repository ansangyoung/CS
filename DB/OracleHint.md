# Oracle Hint  
목적
Oracle 힌트절 Index_ss 추가 및 Index -> Index_ss 로 수정하는 업무를 하면서 몰랐던 개념 정리.  

DBMS 참조  
(https://coding-factory.tistory.com/78)  ﻿
- DBMS(Database Management System)란 데이터베이스 관리 시스템으로, 
데이터베이스를 관리하며 응용 프로그램들이 데이터베이스를 공유하며 사용할 수 있는 환경을 제공하는 소프트웨어.  
- 대표적인 DBMS는 Oracle사의 Oracle, MY_SQL, MicroSoft사의 MS_SQL 등.  

Oracle  
- 오라클에서 만들어 판매중인 상업용 데이터베이스. 
- 윈도우즈, 리눅스, 유닉스 등 다양한 운영체제에 설치를 할 수 있다.  

옵티마이저 참조  
(http://www.dbguide.net/db.db?cmd=view&boardUid=148218&boardConfigUid=9&boardIdx=139&boardStep=1)  
- 옵티마이저(Optimizer)는 SQL을 가장 빠르고 효율적으로 수행할 최적(최저비용)의 처리경로를 생성해 주는 DBMS 내부의 핵심엔진이다.  
- 사용자가 구조화된 질의언어(SQL)로 결과집합을 요구하면, 이를 생성하는데 필요한 처리경로는 DBMS에 내장된 옵티마이저가 자동으로 생성해준다.  
- 옵티마이저가 생성한 SQL 처리경로를 실행계획(Execution Plan)이라고 부른다.  
- 옵티마이저의 SQL 최적화 과정을 요약하면 다음과 같다.  
1. 사용자가 던진 쿼리수행을 위해, 후보군이 될만한 실행계획을 찾는다.  
2. 데이터 딕셔너리(Data Dictionary)에 미리 수집해 놓은 오브젝트 통계 및 시스템 통계정보를 이용해 각 실행계획의 예상비용을 산정한다.  
3. 각 실행계획을 비교해서 최저비용을 갖는 하나를 선택한다.  

옵티마이저 힌트  
- 통계정보가 정확하지 않거나 기타 다른 이유로 옵티마이저가 잘못된 판단을 할 수 있다.  
- 그럴 때 프로그램이나 데이터 특성 정보를 정확히 알고 있는 개발자가 직접 인덱스를 지정하거나 조인 방식을 변경함으로써 더 좋은 실행계획으로 유도하는 메커니즘이 필요한데, 옵티마이저 힌트가 바로 그것이다.  
- 옵티마이저의 판단보다 사용자가 지정한 옵티마이저 힌트가 우선한다.  

인덱스 개념 참조  
(https://lee-mandu.tistory.com/483)  
(https://coding-factory.tistory.com/419)  
- 어떤 데이터가 어느 위치에 있다는 정보를 가진 주소록 같은 개념.  
- 일반적인 select 쿼리를 실행될때 먼저 메모리의 데이터베이스 버퍼 캐시를 살펴본다.  
버퍼 캐시에는 자주 사용되는 테이블들이 캐싱되어 있는데 여기서 데이터가 있을 경우에는 바로 찾아 출력하고,  
없을 경우에는 하드 디스크에 있는 데이터 파일에서 데이터를 찾기 시작한다.  
- 인덱스를 사용한다면 이러한 과정을 거치지 않고 바로 주소를 통해 찾아간다.  
- 즉 인덱스는 데이터베이스 테이블에 있는 데이터를 빨리 찾기 위한 용도의 데이터베이스 객체이며 일종의 색인기술.  
- 테이블에 index를 생성하게 되면 index Table을 생성해 관리한다.  
- 가장 일반적인 B-tree 인덱스는 인덱스 키(인덱스로 만들 테이블의 컬럼 값)와, 이 키에 해당하는 컬럼 값을 가진 테이블의 로우가 저장된 주소 값으로 구성.  

인덱스 생성  
--문법  
CREATE INDEX [인덱스명] ON [테이블명](컬럼1, 컬럼2, 컬럼3.......)  
--예제  
CREATE INDEX EX_INDEX ON CUSTOMERS(NAME, ADDRESS);  

index skip scan(index_ss) 참조  
(https://karisma3s.tistory.com/entry/SQL%ED%8A%9C%EB%8B%9D2110-index-index-range-scan-index-full-scan-index-fast-full-scan-index-skip-scan)  
- 인덱스를 중간 중간 skip 을 해서 사용.  
- 인덱스의 첫번째 컬럼이 where 조건이 없어도 인덱스를 사용할 수 있게 한다.  
create index emp_deptno_sal on emp(deptno, sal);  

select ename, sal  
from emp  
where deptno = 10; -----------------> 위의 index를 사용 함  

select ename, sal  
from emp  
where sal = 3000; ----------------> 위의 index 사용 못 함  

select /*+ index_ss(emp emp_deptno_sal) */ ename, sal  
from emp  
where sal = 3000;  
