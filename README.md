# TODOPrj (23.03.20 ~ 04.28)
* 프로젝트 사용 기술:
  - 프론트 : JSP, JSTL, EL, Java Servlet, HTML, CSS, Javascript
  - 백엔드 : MVC, Annotation, Cookie
  - DBMS : Oracle
  
## 1차 목표: Jsp와 OracleDBMS를 이용한 간단한 로그인 및 회원가입 시스템의 구현

* 진행 기간 : 23.03.20 ~ 03.31      

* 세부 정보
  - MVC 모델을 기반으로 코드를 작성하고, @WebServlet 어노테이션 매핑을 사용한다.
  - 유저의 정보를 담는 테이블을 생성하고 정보 별로 컬럼을 생성한다.
  - 회원가입 시 요구되는 정보는 ID, PWD, 이름, EMAIL이다.
  - 회원가입 시 빈칸이 존재할 경우 "공백이 존재합니다" 오류 메세지를 발생시킨다.
  - 회원가입 시 이미 존재하는 ID 일 경우 중복된 ID임을 고지시킨다.
  - 로그인 시 메인화면으로 연결되며 로그아웃 버튼이 존재한다.
  - 로그인 정보는 쿠키로 유지되며 유지시간은 24H이고 로그아웃 버튼을 누를 시 쿠키를 삭제한다.
  - 로그인을 시도할 때 로그인에 실패하면 "잘못된 아이디나 비밀번호입니다"를 출력한다
  - 쿠키가 없는 상황에서 loginHome.jsp로 바로 접속하려고 한다면 로그인 페이지인 login.jsp로 돌려보낸다.

* 작성 파일
  - com.loginCookeProject.controller
    + LoginController.java
    + LogoutController.java
    + RegisterController.java
    
  - com.loginCookieProject.db.user
    + DBconn.java
    + UserDAO.java
    + UserDTO.java
    
  - JSP
    + login.jsp
    + loginHome.jsp
    + register.jsp

## 2차 목표: ToDoList의 작성, 등록, 수정 그리고 삭제가 가능하며 유저별로 ToDoList의 내용이 표시되도록 구현

* 진행 기간 : 23.04.01 ~ 04.28

* 세부 정보
  - ToDo List 정보를 담는 테이블을 생성하고 정보 별로 컬럼을 생성한다.
  - ToDo List의 등록 시 요구되는 정보는 Title, List, EndDate이다.
  - ToDo List는 loginHome.jsp에서 현재 로그인 한 사용자의 ToDo List를 불러오도록 한다.
  - 불러온 ToDo List의 정보는 ```<thead>``` , ```<th>``` 태그를 사용하여 가시성을 확보한다.
  - 신규 ToDo List의 등록은 loginHome.jsp에서 가능하게 한다.
  - Todo List의 상세 정보는 ```todoDetail?todoIndex=``` 쿼리스트링을 사용하여 페이지를 이동시킨다.
  - TodoDetail 상세 정보 페이지에서 목록으로 돌아가거나 수정 및 삭제가 가능하다.
  
* 작성 파일
  - com.loginCookeProject.controller
    + TodoDelController.java
    + TodoDetailController.java
    + TodoRegisterController.java
    + TodoUpdateController.java
    
  - com.loginCookieProject.db.todo
    + DBconn.java
    + TodoDAO.java
    + TodoDTO.java
    
  - JSP
    + loginHome.jsp
    + todoDetail.jsp
    + todoRegister.jsp
    + todoUpdate.jsp
