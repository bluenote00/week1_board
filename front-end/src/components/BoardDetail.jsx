import React, { useState, useEffect } from 'react';
import axios from 'axios';
import '../css/BoardDetail.css';

const BoardDetail = ({ item, onClose, mode, onSaved }) => {
  const isEdit = mode === 'edit';
  const [isEditing, setIsEditing] = useState(mode === 'post');

  // 초기값 설정
  const [boardName, setBoardName] = useState('');
  const [boardContent, setBoardContent] = useState('');
  const [userName, setUserName] = useState('');
  const [boardDate, setBoardDate] = useState('');

  // item 또는 mode가 바뀔 때마다 값 초기화
  useEffect(() => {
    if (isEdit && item) {
      setBoardName(item.board_name || '');
      setBoardContent(item.board_content || '');
      setUserName(item.user_name || '');
      setBoardDate(item.board_date || '');
    } else {
      // 신규 등록 시 초기값 설정
      setBoardName('');
      setBoardContent('');
      setUserName('');
    }
  }, [item, mode, isEdit]);

  const handleSave = async () => {
    if (!boardName) {
      alert('제목을 입력해주세요.');
      return;
    }
  
    const payload = {
      board_name: boardName,
      board_content: boardContent,
      user_name: userName,
      ...(isEdit && { board_no: item?.board_no }),
    };

    
    try {
      if (isEdit) {
        await axios.post('/board/updateBoard', payload);
        alert('수정되었습니다.');
      } else {
        await axios.post('/board/insertBoard', payload);
        alert('등록되었습니다.');
      }
  
      onSaved();
      onClose();
    } catch (err) {
      console.error(`${isEdit ? '수정' : '등록'} 실패:`, err);
      alert(`${isEdit ? '수정' : '등록'}에 실패했습니다.`);
    }
  };
  

  if (isEdit && !item) return null;

  return (
    <div className="detail-overlay" onClick={onClose}>
      <div className="detail-modal" onClick={(e) => e.stopPropagation()}>
        <button className="detail-close" onClick={onClose}>×</button>
        <div className="detail-header_product"></div>

        <div className="detail-Wrapper">
          <div className="detail-body">
            <h3 className="detail-text">제목</h3>
            {isEditing ? (
              <input
                className="detail-input-question"
                value={boardName}
                onChange={(e) => setBoardName(e.target.value)}
              />
            ) : (
              <p className="detail-text">{boardName}</p>
            )}
          </div>

          <div className="detail-body">
            <h3 className="detail-text">작성자</h3>
            <p className="detail-text">{userName}</p>
          </div>

          <div className="detail-body">
            <h3 className="detail-text">날짜</h3>
             <p className="detail-text">{boardDate}</p>
          </div>

          <div className="detail-body">
            <h3 className="detail-text">내용</h3>
            {isEditing ? (
              <textarea
                className="detail-textarea-answer_product"
                value={boardContent}
                onChange={(e) => setBoardContent(e.target.value)}
              />
            ) : (
              <p className="detail-text">{boardContent}</p>
            )}
          </div>

        <div className="detail-footer">
          <button
            className="btn-edit"
            onClick={() => setIsEditing(prev => !prev)}
          >
            {isEditing ? '취소' : '수정'}
          </button>
          {isEditing && (
            <button className="btn-save" onClick={handleSave}>
              저장
            </button>
          )}
        </div>
      </div>
    </div>
    </div>
  );
};

export default BoardDetail;