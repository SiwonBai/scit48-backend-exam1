# 📘 scit 48기 백엔드 과제1: Spring Boot 회원 관리 시스템

Spring Boot + Thymeleaf를 이용하여 구현한  
**회원가입 · 로그인 · 로그아웃 · 회원목록 조회** 기능을 가진 간단한 웹 프로젝트입니다.

---

# ✨ 주요 기능

## 1️⃣ 회원가입 (Sign Up)
- ID, PW, 이름, 전화번호 입력
- JavaScript로 유효성 검사
- 회원가입 시 ID가 세션에 저장됨

![img_1.png](images/img_1.png)


## 2️⃣ 로그인 (Login)
- 세션에 저장된 ID/PW 기반으로 로그인 확인
- 로그인 성공 시 세션에 `loginId` 저장
- **ID 기억하기(localStorage)** 기능 포함  
  → 체크하면 다음 로그인 때 자동으로 ID 입력됨

![img_2.png](images/img_2.png)
![img_3.png](images/img_3.png)


## 3️⃣ 로그아웃 (Logout)
- 세션 invalidate()로 로그아웃 처리
- 로그아웃 후 홈 화면으로 이동



## 4️⃣ 회원목록 조회 (User List)
- DB에 저장된 모든 회원 목록을 테이블로 출력
- Bootstrap을 사용해 테이블 UI 구성

![img_4.png](images/img_4.png)


## 5️⃣ 공통 배너 (Header)
- Thymeleaf fragment로 구현
- 로그인 여부에 따라 메뉴 자동 변경

### 로그인 전:
- 홈 / 회원가입 / 로그인

### 로그인 후:
- 홈 / 로그아웃 / 회원목록


---

# 🛠 기술 스택

### Environment

![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ%20IDEA-000000?style=for-the-badge&logo=intellijidea&logoColor=white)
![Git](https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=git&logoColor=white)
![GitHub](https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=github&logoColor=white)

### Backend

![Java](https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=OpenJDK&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)

### Frontend

![HTML](https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=html5&logoColor=white)
![CSS](https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=css3&logoColor=white)
![JavaScript](https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black)
![Bootstrap](https://img.shields.io/badge/Bootstrap-7952B3?style=for-the-badge&logo=bootstrap&logoColor=white)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-005F0F?style=for-the-badge&logo=thymeleaf&logoColor=white)

### Database

![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)  