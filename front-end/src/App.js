import { useState } from "react";
import './App.css';
import Main from "./components/Main";
import JoinForm from "./components/JoinForm";
import LoginForm from "./components/LoginForm";

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
    </div>
  );
}

export default App;
