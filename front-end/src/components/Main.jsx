import "../css/Join.css";

import { useNavigate } from "react-router-dom";
import { useState } from "react"; 

function Main() {
  return (
      <div className="loginSection">
        <h1>로그인</h1>
          <p>아이디</p>
          <input></input>
          <p>비밀번호</p>
          <input></input>
          <div>
          <button>로그인</button>
          <button>회원가입</button>
        </div>
      </div>
  );
}

export default Main;
