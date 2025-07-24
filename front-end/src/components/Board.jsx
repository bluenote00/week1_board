import '../css/Board.css';
import Pagination from '../components/common/Pagination';
import BoardDetail from '../components/BoardDetail';
import { useState, useEffect } from 'react';

import axios from 'axios';


const Board = () => {
  const [data, setData] = useState([]);
  const [selected, setSelected] = useState([]);
  const [isAllSelected, setIsAllSelected] = useState(false);
  const [currentPage, setCurrentPage] = useState(1);
  const [detailItem, setDetailItem] = useState(null);
  const [isDetailOpen, setIsDetailOpen] = useState(false);
  const [modalMode, setModalMode] = useState('edit');
  const [totalCount, setTotalCount] = useState(0);

  useEffect(() => { 
    const fetchData = async () => {
      try {
        const res = await axios.get('/board/boardList', {
          params: {
            currentpage: currentPage,
            pagesize: itemsPerPage
          }
        });
          setData(res.data.boardList);
          setTotalCount(res.data.totalcnt);
      } catch (err) {
        console.error('게시글 불러오기 실패:', err);
      }
    };

    fetchData();
  }, [currentPage]);

  const deleteBoard = async () => {
    if (selected.length === 0) {
      alert('삭제할 게시글을 선택해주세요.');
      return;
    }

    if (!window.confirm('선택한 게시글을 삭제하시겠습니까?')) return;

    try {
      await axios.post('/board/deleteBoard', { board_no: selected });
      alert('삭제가 완료되었습니다.');

      // 삭제 후 목록 다시 가져오기
      const res = await axios.get('/board/boardList', {
        params: {
          currentpage: currentPage,
          pagesize: itemsPerPage
        }
      });

      setData(res.data.boardList);
      setTotalCount(res.data.totalcnt);
      setSelected([]);
    
    } catch (err) {
      console.error('글 삭제 실패:', err);
      alert('삭제 중 오류가 발생했습니다.');
    }
  };

  const itemsPerPage = 10;
  const currentItems = data;
  const totalPages = Math.ceil(totalCount / itemsPerPage);

  useEffect(() => {
    const allSelected = currentItems.length > 0 &&
      currentItems.every(item => selected.includes(item.board_no));
    setIsAllSelected(allSelected);
  }, [currentItems, selected]);

  const toggleCheckbox = (board_no) => {
    setSelected(prev =>
      prev.includes(board_no) ? prev.filter(item => item !== board_no) : [...prev, board_no]
    );
  };

  const toggleAllCheckboxes = () => {
    if (isAllSelected) {
      setSelected([]);
    } else {
      const allIds = currentItems.map(item => item.board_no);
      setSelected(allIds);
    }
    setIsAllSelected(!isAllSelected);
  };


  const openDetail = (item) => {
    setModalMode('edit');
    setDetailItem(item);
    setIsDetailOpen(true);
  };

  const openNewPostModal = () => {
    setModalMode('post');
    setDetailItem(null);
    setIsDetailOpen(true);
  }

  return (
    <div className='infoManagement'>
      <div className='info-content'>
        <div className='info-section-title-box'>
          <h2>게시판</h2>
        </div>

        <div className='info-section-content-box'>
          <div className='info-header'>
            <div className='info-controls'>
              <button onClick={deleteBoard}>선택 삭제</button>
              <button onClick={openNewPostModal}>글 작성</button>
            </div>
          </div>

          {isDetailOpen && (
            <BoardDetail
              item={detailItem}
              onClose={() => setIsDetailOpen(false)}
              mode={modalMode}
              onSaved={() => {
                axios.get('/board/boardList', {
                  params: {
                    currentpage: currentPage,
                    pagesize: itemsPerPage,
                  },
                })
                  .then((res) => {
                    setData(res.data.boardList);
                    setTotalCount(res.data.totalcnt);
                  })
                  .catch((err) => console.error(err));
              }}
            />
          )} 

          <table className='info-table'>
            <thead>
              <tr>
                <th>
                  <input
                    type='checkbox'
                    checked={isAllSelected}
                    onChange={toggleAllCheckboxes}
                  />
                </th>
                <th>번호</th>
                <th>제목</th>
                <th>작성자</th>
                <th>등록일자</th>
              </tr>
            </thead>
            <tbody>
              {currentItems.map((item) => (
                <tr key={item.board_no}>
                  <td>
                    <input
                      type='checkbox'
                      checked={selected.includes(item.board_no)}
                      onChange={() => toggleCheckbox(item.board_no)}
                    />
                  </td>
                  <td>{item.board_no}</td>
                  <td className="info-title"
                    onClick={() => openDetail(item)}>{item.board_name}</td>
                  <td> {item.user_name}</td>
                  <td>{item.board_date}</td>
                </tr>
              ))}
            </tbody>
          </table>

          <Pagination
            currentPage={currentPage}
            totalPages={totalPages}
            setCurrentPage={setCurrentPage}
          />

        </div>
      </div>
    </div>
  );
};

export default Board;