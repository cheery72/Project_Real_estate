# Project_Real_estate
아파트 실거래 매매 정보 제공 사이트



프로젝트 개요

진행기간: 2021.11.19 ~ 2021.11.25

목표

1. 시군동 아파트 검색으로 아파트 실거래 정보를 조회할 수 있다.

1. 아파트 검색으로 지하철, 학교와 같이 아파트 주변 주요시설을 한눈에 확인할 수 있다.

2. 아파트 주변의 안전을 중요시 하는 사용자들에게 아파트 주변의 CCTV 정보를 제공한다.

3. 즐겨찾기를 통해서 사용자가 관심있어 하는 아파트 정보를 조회 및 비교할 수 있다.

4. 각각의 아파트마다 리뷰와 소통을 위해서 게시글 & 댓글 기능을 제공한다.



Features

## 주요기능

회원가입

- 회원 정보를 입력하여 서버에 회원등록이 가능합니다.
- 현재 db에 등록되어있는 아이디인지를 체크하여 아이디가 사용가능한지를 판단합니다.
- 비밀번호 validation 기능을 추가하였습니다.
- 비밀번호가 일치하는지 확인하는 기능을 추가하였습니다.

로그인

- jwt토큰 기반인증으로 로그인을 구현
- 로그인 성공 시 Navbar에 로그인한 사용자의 이름과 이메일을 표시합니다.

회원정보 조회/수정/삭제

- 가입한 회원의 정보를 한눈에 파악할 수 있도록 내 정보 확인 페이지를 구현하였습니다.
- 사용자 아이디, 비밀번호, 이름, 주소를 조회하고 수정 할 수 있습니다.
- 회원탈퇴 시 메인화면으로 이동합니다.

즐겨찾기

- 아파트 상세정보에서 관심아파트 등록버튼을 누를 시 즐겨찾기 목록에 추가됩니다.
- 추가된 관심아파트 목록은 내 관심 주택 페이지 클릭시 확인이 가능합니다.
- 테이블 형태로 구성되어 관심주택을 빠르게 조회 및 비교할 수 있습니다.
- 관심 주택 삭제 시 바로 삭제 목록이 갱신되어 반영됩니다.

cctv 정보

- 주택 클릭 시 해당 주택을 중심으로 500미터 반경의 원을 지도에 생성합니다.

- 반경내 CCTV 갯수를 아파트 상세정보에서 확인할 수 있다.

  

아파트 검색



아파트 상세정보 조회



지도 마커 기능



게시글 & 댓글





사용 기술

Spring Boot

Vuex

Axios

Mysql

MyBatis



페이지 소개

![image-20211129150607515](C:\Users\nutmy\AppData\Roaming\Typora\typora-user-images\image-20211129150607515.png)

![image-20211129150617057](C:\Users\nutmy\AppData\Roaming\Typora\typora-user-images\image-20211129150617057.png)

![image-20211129150626536](C:\Users\nutmy\AppData\Roaming\Typora\typora-user-images\image-20211129150626536.png)

![image-20211129150632415](C:\Users\nutmy\AppData\Roaming\Typora\typora-user-images\image-20211129150632415.png)

![image-20211129150636585](C:\Users\nutmy\AppData\Roaming\Typora\typora-user-images\image-20211129150636585.png)

![image-20211129150640947](C:\Users\nutmy\AppData\Roaming\Typora\typora-user-images\image-20211129150640947.png)

