import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

import axios from 'axios';
import "../css/Form.css";

const Main = ({ onJoinClick }) => {
  const [loginId, setLoginId] = useState('');
  const [password, setPassword] = useState('');

  const navigate = useNavigate(); 

    
  const handleLogin = async () => {
    if (!loginId || !password) {
      alert('모든 항목을 입력해주세요.');
      return;
    }

    const payload = {
      login_id: loginId,
      password: password,
    };

    console.log('로그인 정보:', payload);
    try {
      const res = await axios.post('/login/loginUser', payload);
      const status = res.data.status;
      const message = res.data.message;

      if (status === 'null') {
        alert(message);
      
      } else if (status === 'fail') {
        alert(message);

      } else if (status === 'success') {
        alert(message);
        navigate('/board');
      }

      } catch (err) {
      alert('로그인에 실패했습니다.');
    }
  };

  return (
    <div className="loginSection">
      <h1>로그인</h1>
          <h3>아이디</h3>
          <input value={loginId}
          onChange={(e) => setLoginId(e.target.value)}
           />

          <h3>비밀번호</h3>
          <input type="password" value={password}
           onChange={(e) => setPassword(e.target.value)} />
      <div>
        <button onClick={handleLogin}>로그인</button>
        <button onClick={onJoinClick}>회원가입</button>
      </div>
    </div>
  );
};

export default Main;
