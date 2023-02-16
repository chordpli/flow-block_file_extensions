# 과제 설명
파일 첨부시 보안에 문제가 발생할 수 있다.
특히 exe, sh등의 실행 파일이 존재하여, 서버에 업로드 된다면 실행될 수 있는 위험이 존재하기 때문에 파일 확장자 차단을 하게 되었습니다.

## 요건
1. 고정 확장자는 차단을 자주하는 확장자 리스트이며, default는 unCheck입니다.
2. 고정 확장자를 check or uncheck를 할 경우 db에 저장됩니다. - 새로고침시 유지되어야합니다.
   (아래쪽 커스텀 확장자에는 표현되지 않으니 유의)
3. 확장자 최대 입력 길이는 20자리입니다.
4. 추가 버튼 클릭시 db에 저장되며, 아래쪽 영역에 표현됩니다.
5. 커스텀 확장자는 최대 200개까지 추가 가능합니다.
6. 확장자 옆 X를 클릭할 경우 DB에서 삭제됩니다.

위 요건 이외에 어떤 점을 고려했는지 작성해주세요.
ex) 커스텀 확장자 중복 체크
커스텀 확장자 sh를 추가한 후 다시 sh를 추가하는 상황을 고려하여 개발.