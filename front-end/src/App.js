import { useState } from "react";
import './App.css';
import Main from "./components/Main";
import JoinForm from "./components/JoinForm";

function App() {
  const [isJoinModalOpen, setIsJoinModalOpen] = useState(false);

  const openJoinModal = () => setIsJoinModalOpen(true);
  const closeJoinModal = () => setIsJoinModalOpen(false);

  return (
    <div className="App">
      <Main onJoinClick={openJoinModal} />
      {isJoinModalOpen && (
        <JoinForm onClose={closeJoinModal} />
      )}
    </div>
  );
}

export default App;
