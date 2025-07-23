import React, { useState } from 'react';
import axios from 'axios';
import "../css/Form.css";

const LoginForm = ({ onClose }) => {
  const [loginId, setLoginId] = useState('');
  const [userName, setUserName] = useState('');
  const [userEmail, setUserEmail] = useState('');
  const [password, setPassword] = useState('');

  const handleLogin = async () => {
    if (!loginId || !password) {
      alert('모든 항목을 입력해주세요.');
      return;
    }

    const payload = {
      login_id: loginId,
      user_name: userName,
      user_email: userEmail,
      password: password,
    };

    try {
      const res = await axios.post('/join/register', payload);
      const message = res.data.message;

      if (message == '1') {
        alert('이미 존재하는 아이디입니다.');
      
      } else if (message == '2') {
        alert('회원가입이 완료되었습니다.');
        onClose();
      }

      } catch (err) {
      alert('가입에 실패했습니다.');
    }
  };

  return (
    <div className="detail-overlay" onClick={onClose}>
      <div className="detail-modal">
        <div className="detail-body">
          <h3>아이디</h3>
          <input value={loginId} />

          <h3>비밀번호</h3>
          <input type="password" value={password} />
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
