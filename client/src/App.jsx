import { BrowserRouter, Route, Routes, Navigate } from "react-router-dom";
import NavBar from "./components/NavBar";
import TasksPage from "./pages/TasksPage";
import TaskFormPage from "./pages/TaskFormPage";

function App() {
    return (
        <BrowserRouter>
            <NavBar />
            <div className="container grid place-items-center mt-6 w-4/5 m-auto">
                <Routes>
                    <Route path="/" element={<Navigate to="/tasks" />} />
                    <Route path="/tasks" element={<TasksPage />} />
                    <Route path="/tasks/:id" element={<TaskFormPage />} />
                    <Route path="/create-task" element={<TaskFormPage />} />
                </Routes>
            </div>
        </BrowserRouter>
    );
}

export default App;
