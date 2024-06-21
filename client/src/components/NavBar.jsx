import React from "react";
import { Link } from 'react-router-dom';

const NavBar = () => {
    return (
        <div className="p-3 text-slate-100 flex justify-between w-4/5 m-auto">
            <Link className="hover:underline underline-offset-4 text-3xl" to='/tasks'>Home</Link>
            <Link className="pt-2 hover:underline underline-offset-4 text-xl" to='/create-task'>Create Task</Link>
        </div>
    )
};

export default NavBar;
