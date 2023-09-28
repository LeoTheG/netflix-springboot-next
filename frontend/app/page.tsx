import { Home } from "@/components/Home";
import { UserService } from "@/components/UserService";
import { Metadata } from "next";

export const metadata: Metadata = {
  title: "Home - Netflix"
};

export default function Page() {
  return (
    <>
      <div className="dark">
        <div className="min-w-screen min-h-screen bg-background">
          <Home />
        </div>
      </div>
    </>
  );
}
