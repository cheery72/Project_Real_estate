# Project_Real_estate

아파트 실거래 매매 정보 제공 사이트



## 프로젝트 개요

**진행기간**: 2021.11.19 ~ 2021.11.25

**목표**

- 시군동 아파트 검색으로 아파트 실거래 정보를 조회할 수 있다.

- 아파트 검색으로 지하철, 학교와 같이 아파트 주변 주요시설을 한눈에 확인할 수 있다.

- 아파트 주변의 안전을 중요시 하는 사용자들에게 아파트 주변의 CCTV 정보를 제공한다.

- 즐겨찾기를 통해서 사용자가 관심있어 하는 아파트 정보를 조회 및 비교할 수 있다.

- 각각의 아파트마다 리뷰와 소통을 위해서 게시글 & 댓글 기능을 제공한다.



## 주요기능

**회원가입**

- 회원 정보를 입력하여 서버에 회원등록이 가능합니다.
- 현재 db에 등록되어있는 아이디인지를 체크하여 아이디가 사용가능한지를 판단합니다.
- 비밀번호 validation 기능을 추가하였습니다.
- 비밀번호가 일치하는지 확인하는 기능을 추가하였습니다.

**로그인**

- jwt토큰 기반인증으로 로그인을 구현
- 로그인 성공 시 Navbar에 로그인한 사용자의 이름과 이메일을 표시합니다.

**회원정보 조회/수정/삭제**

- 가입한 회원의 정보를 한눈에 파악할 수 있도록 내 정보 확인 페이지를 구현하였습니다.
- 사용자 아이디, 비밀번호, 이름, 주소를 조회하고 수정 할 수 있습니다.
- 회원탈퇴 시 메인화면으로 이동합니다.

**즐겨찾기**

- 아파트 상세정보에서 관심아파트 등록버튼을 누를 시 즐겨찾기 목록에 추가됩니다.
- 추가된 관심아파트 목록은 내 관심 주택 페이지 클릭시 확인이 가능합니다.
- 테이블 형태로 구성되어 관심주택을 빠르게 조회 및 비교할 수 있습니다.
- 관심 주택 삭제 시 바로 삭제 목록이 갱신되어 반영됩니다.

**cctv 정보**

- 주택 클릭 시 해당 주택을 중심으로 500미터 반경의 원을 지도에 생성합니다.

- 반경내 CCTV 갯수를 아파트 상세정보에서 확인할 수 있다.

  

**아파트 & 주변 시설 검색**

- 시구동 검색으로 아파트를 검색할 수 있다.
- 아파트 주변의 학교, CCTV, 지하철 정보를 확인할 수 있다.

**아파트 상세정보 조회**

- 선택한 해당 아파트의 가격, 층 등 아파트의 상세정보를 확인할 수 있다.


**게시글 & 댓글**

- 각각의 아파트에 리뷰를 작성할 수 있다.
- 각각의 리뷰에 댓글을 작성할 수 있다.

## 사용 기술

**Frontend**

-  axios: 0.24.0
-  core-js: 3.6.5
-  jwt-decode: 3.1.2
-  vue: 2.6.14
-  vue-router: 3.2.0
-  vuex: 3.4.0
-  vuex-persistedstate: 4.1.0

**Bakend** 

- Spring Boot
- Mysql

- MyBatis



## 페이지 소개

![회원가입](https://user-images.githubusercontent.com/69693631/144235679-a9149370-b5ce-4198-824f-43e536627af5.png)
![로그인](https://user-images.githubusercontent.com/69693631/144235797-25e5beaf-8d74-4c52-9823-86bd0f1d2395.png)
![회원수정](https://user-images.githubusercontent.com/69693631/144235914-bda92203-716d-4868-9db8-b7b5e8290667.png)
![아파트검색](https://user-images.githubusercontent.com/69693631/144235883-8630afa1-8cbf-440f-b08a-af6610b66456.png)
![즐겨찾기](https://user-images.githubusercontent.com/69693631/144235956-1f544660-0d2e-497d-b4d7-329469a8a1c3.png)
![게시글](https://user-images.githubusercontent.com/69693631/144236836-36c53e76-c99c-4a22-bdf0-bc430b005b5a.png)
![댓글](https://user-images.githubusercontent.com/69693631/144236902-9f27111e-9f8e-4ca1-8ef0-322e123284f8.png)
