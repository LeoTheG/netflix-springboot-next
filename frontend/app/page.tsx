import { UserService } from "@/components/UserService";

export default function Home() {
  return (
    <div className="dark">
      <div className="min-w-screen min-h-screen bg-background">
        <div className="p-16 max-w-[1000px] flex flex-col gap-8">
          <h1 className="text-primary text-3xl">User Service</h1>
          <UserService />
        </div>
      </div>
    </div>
  );
}
