import { EditorProvider } from "@/components/EditorContext";
import SplitView from "@/components/SplitView";

export default function Home() {
  return (
    <EditorProvider>
      <SplitView />
    </EditorProvider>
  );
}