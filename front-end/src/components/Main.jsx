
const Main = ({ onLoginClick, onJoinClick }) => {
  return (
    <div className="loginSection">
      <h1>로그인</h1>
      <p>아이디</p>
      <input />
      <p>비밀번호</p>
      <input />
      <div>
        <button onClick={onLoginClick}>로그인</button>
        <button onClick={onJoinClick}>회원가입</button>
      </div>
    </div>
  );
};

export default Main;
