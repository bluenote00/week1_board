import { useState } from "react";
import { Routes, Route, useLocation } from "react-router-dom";
import './App.css';
import Main from "./components/Main";
import JoinForm from "./components/JoinForm";
import Board from "./components/Board";

function App() {
  const [isJoinModalOpen, setIsJoinModalOpen] = useState(false);

  const openJoinModal = () => setIsJoinModalOpen(true);
  const closeJoinModal = () => setIsJoinModalOpen(false);

  return (
    <div className="App">
      <Routes>
        <Route
          path="/"
          element={
            <>
              <Main onJoinClick={openJoinModal} />
              {isJoinModalOpen && <JoinForm onClose={closeJoinModal} />}
            </>
          }
        />
        <Route path="/board" element={<Board />} />
      </Routes>
    </div>
  );
}

export default App;
