import { useNavigate } from "react-router-dom";
import { deleteTask } from "../api/task.api";

const TaskCard = ({ task }) => {
    const navigate = useNavigate();

    const handleDelete = () => {
        const accepted = window.confirm("Are you sure you want to delete this task?")
        if(accepted){
            deleteTask(task.id)
            navigate(0)
        }
    }

    const handleCardClick = (e) => {
        if (!e.target.matches("img")) {
            navigate(`/tasks/${task.id}`);
        }
    };

    return (
        <div
            onClick={handleCardClick}
            className="border-gray-600 border bg-slate-800 text-cyan-50 rounded p-4 flex flex-col justify-between max-w-sm m-3 hover:cursor-pointer hover:border-gray-400"
        >
            <div className="mb-8">
                <div className="text-cyan-50 font-bold text-xl mb-2">{task.title}</div>
                <p className="text-gray-400 text-base">{task.description.length > 50 ? task.description.slice(0, 70) + " ..." : task.description}</p>
            </div>
            <div className="flex justify-between">
                <img onClick={handleDelete} className="focus:outline-none bg-red-800 hover:bg-red-900 focus:ring-4 focus:ring-red-300 rounded-lg p-1 w-7" src="../../icons8-delete.png" alt="trash" />
                <div className="text-sm pt-1">
                    <p className="text-gray-600">{task.created.split("T")[0]}</p>
                </div>
            </div>
        </div>
    );
};

export default TaskCard;
