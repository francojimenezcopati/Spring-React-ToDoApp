import TaskCard from "../components/TaskCard";
import { getTasks } from '../api/task.api'
import { useEffect, useState } from "react";

const TasksPage = () => {
    const [tasks, setTasks] = useState([])

    useEffect(() => {
        getTasks().then(tasks => setTasks(tasks))
    }, [])

    return (
        <div className="text-cyan-50 grid grid-cols-3 "> 
            {tasks && tasks.map(task => (
                // <div key={task.id}>{task.title}</div>
                <TaskCard key={task.id} task={task}/>
            ))}
        </div>
    )
};

export default TasksPage;

