"use client";
import { createContext, useContext, useState } from "react";

const EditorContext = createContext<any>(null);

export function EditorProvider({ children }: { children: React.ReactNode }) {
  const [jsonText, setJsonText] = useState("{\n  \"hello\": \"world\"\n}");
  const [jsonObject, setJsonObject] = useState<any>({ hello: "world" });
  const [darkMode, setDarkMode] = useState(false);

  return (
    <EditorContext.Provider
      value={{
        jsonText,
        setJsonText,
        jsonObject,
        setJsonObject,
        darkMode,
        setDarkMode
      }}
    >
      {children}
    </EditorContext.Provider>
  );
}

export const useEditor = () => useContext(EditorContext);