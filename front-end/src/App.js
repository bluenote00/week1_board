import { Routes, Route } from "react-router-dom";

import './App.css';
import Main from "./components/Main";
import Login from "./components/Main";
import Join from "./components/JoinForm";

function App() {
  return (
    <div className="App">
      <Main />
       <Routes>
          <Route path="/" element={<Main />} />
          <Route path="/login" element={<Login />} />
          <Route path="/join" element={<Join />} />
        </Routes>
    </div>
  );
}

export default App;
