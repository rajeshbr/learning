"use client";
import { useEditor } from "./EditorContext";

export default function Toolbar() {
  const { jsonObject, setJsonText, darkMode, setDarkMode } = useEditor();

  return (
    <div className="flex gap-2 p-2 border-b bg-white dark:bg-gray-900">
      <button onClick={() => setJsonText(JSON.stringify(jsonObject, null, 2))}>Format</button>
      <button onClick={() => setJsonText(JSON.stringify(jsonObject))}>Compact</button>
      <button onClick={() => setDarkMode(!darkMode)}>Dark Mode</button>
    </div>
  );
}