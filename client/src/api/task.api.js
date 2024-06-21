const BASE_URL = "http://localhost:8080/api/v1/tasks/";

export const getTasks = async () => {
    const response = await fetch(BASE_URL);
    const data = await response.json();
    return data;
};

export const createTask = (task) => {
    fetch(BASE_URL, {
        method: "POST", // Especifica que esta es una solicitud POST
        headers: {
            "Content-Type": "application/json", // Indica que el cuerpo de la solicitud es JSON
        },
        body: JSON.stringify(task), // Convierte el objeto de tarea a formato JSON JSON.stringify(task)
    })
        .then((response) => response.json())
        .then((data) => console.log(data))
        .catch((error) => console.error("Error al realizar la solicitud:", error));

    return;
};

export const deleteTask = (id) => {
    fetch(BASE_URL + `${id}/`, {
        method: "DELETE",
    })
        .then((response) => response.json())
        .then((data) => console.log(data))
        .catch((error) => console.error("Error al realizar la solicitud:", error));

    return;
};

export const updateTask = (id, task) => {
    fetch(BASE_URL + `${id}/`, {
        method: "PUT",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(task),
    })
        .then((response) => response.json())
        .then((data) => console.log(data))
        .catch((error) => console.error("Error al realizar la solicitud:", error));

    return;
};

export const getTaskDetails = async (id) => {
    const response = await fetch(BASE_URL + `${id}/`);
    const data = await response.json();
    return data;
};
