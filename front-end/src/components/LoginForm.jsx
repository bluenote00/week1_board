import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

import axios from 'axios';
import "../css/Form.css";

const LoginForm = ({ onClose }) => {
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
        onClose();
        navigate('/board');
      }

      } catch (err) {
      alert('로그인에 실패했습니다.');
    }
  };

  return (
    <div className="detail-overlay" onClick={onClose}>
      <div className="detail-modal" onClick={(e) => e.stopPropagation()}>
        <div className="detail-body">
          <h3>아이디</h3>
          <input value={loginId}
          onChange={(e) => setLoginId(e.target.value)}
           />

          <h3>비밀번호</h3>
          <input type="password" value={password}
           onChange={(e) => setPassword(e.target.value)} />
        </div>

        <div className="detail-footer">
           <button className="btn-save" onClick={onClose}>닫기</button>
          <button className="btn-save" onClick={handleLogin}>로그인</button>
        </div>
      </div>
    </div>
  );
};

export default LoginForm;
