import TreeEditor from "./TreeEditor";
import Toolbar from "./Toolbar";

export default function SplitView() {
  return (
    <div className="flex flex-col h-screen">
      <Toolbar />
      <div className="flex flex-1">
        <TreeEditor />
        <p>Space</p>
        <TreeEditor />
      </div>
    </div>
  );
}