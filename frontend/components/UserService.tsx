"use client";

import axios from "axios";
import { Button } from "./ui/button";
import { Input } from "./ui/input";
import { useState } from "react";

export const UserService = () => {
  const [users, setUsers] = useState<IUser[]>([]);

  const handleCreate = () => {
    axios.post("http://localhost:8080/users", {
      name: "test",
      email: "testemail@example.com"
    });
  };

  const handleGetAllUsers = async () => {
    const result = await axios.get("http://localhost:8080/users");
    console.log(result.data);
    setUsers(result.data);
  };
  return (
    <div className="flex flex-col gap-4">
      <h2 className="text-xl text-primary underline underline-offset-4">
        Create User
      </h2>
      {/* <Input placeholder="Username" className="w-[300px]" />
       */}
      <Button className="w-fit" onClick={handleCreate}>
        Create
      </Button>
      <Button className="w-fit" onClick={handleGetAllUsers}>
        Get All
      </Button>
      {users.map((user) => {
        return (
          <div
            key={user.id}
            className="text-primary border-2 border-primary border-solid p-4 rounded-md"
          >
            <p>{user.name}</p>
            <p>{user.email}</p>
          </div>
        );
      })}
    </div>
  );
};

/*
{
    "id": 1,
    "name": "test",
    "email": "testemail@example.com"
}
*/
interface IUser {
  id: number;
  name: string;
  email: string;
}
