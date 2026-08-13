"use client";
import Editor from "@monaco-editor/react";
import { useEditor } from "./EditorContext";

export default function MonacoJsonEditor() {
  const { jsonText, setJsonText, setJsonObject, darkMode } = useEditor();

  const onChange = (value?: string) => {
    if (!value) return;
    setJsonText(value);
    try {
      setJsonObject(JSON.parse(value));
    } catch {}
  };

  return (
    <Editor
      height="100%"
      defaultLanguage="json"
      value={jsonText}
      theme={darkMode ? "vs-dark" : "light"}
      onChange={onChange}
      options={{ automaticLayout: true, minimap: { enabled: false } }}
    />
  );
}