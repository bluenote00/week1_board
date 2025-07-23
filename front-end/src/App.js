import { useState } from "react";
import { Routes, Route } from "react-router-dom";
import './App.css';
import Main from "./components/Main";
import JoinForm from "./components/JoinForm";
import LoginForm from "./components/LoginForm";
import Board from "./components/Board";

function App() {
  const [isJoinModalOpen, setIsJoinModalOpen] = useState(false);
  const [isLoginModalOpen, setIsLoginModalOpen] = useState(false);

  const openJoinModal = () => setIsJoinModalOpen(true);
  const closeJoinModal = () => setIsJoinModalOpen(false);

  const openLoginModal = () => setIsLoginModalOpen(true);
  const closeLoginModal = () => setIsLoginModalOpen(false);

  return (
    <div className="App">
      <Main onJoinClick={openJoinModal} onLoginClick={openLoginModal} />
      {isJoinModalOpen && (
        <JoinForm onClose={closeJoinModal} />
      )}
      {isLoginModalOpen && (
        <LoginForm onClose={closeLoginModal} />
      )}
      <Routes>
        <Route path="/board" element={<Board />} />
      </Routes>
    </div>
  );
}

export default App;
