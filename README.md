# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 구현 목록
1. BaseballGame 클래스 생성 (Entrypoint 생성)
2. 번호 생성
3. BaseballGame의 전체 loop 생성
4. BaseballGame의 사용자 입력(공격) 루프 생성
5. 입력요청 텍스트 출력
6. 사용자 입력
7. 사용자 입력과 생성된 번호 스트라이크/볼/낫씽 판단
   1. 3스트라이크일 경우 재시작 & 게임종료 텍스트 출력   
       - 사용자 입력
         - 재시작의 경우 번호 생성으로 이동
         - 게임 종료
   2. 3스트라이크가 아닌 경우
      - 입력 텍스트 출력으로 이동
   3. 입력 예외처리 (length 다름, 숫자 아닌 값 포함)
      - 예외 텍스트 출력