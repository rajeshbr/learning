"use client";
import { JSONEditor } from "vanilla-jsoneditor";
import { useEffect, useRef } from "react";
import { useEditor } from "./EditorContext";
//import "vanilla-jsoneditor/themes/defaults.scss";
import "vanilla-jsoneditor/themes/jse-theme-dark.css";

export default function TreeEditor() {
  const ref = useRef<HTMLDivElement>(null);
  const editor = useRef<JSONEditor | null>(null);
  const { jsonObject, setJsonObject, setJsonText, darkMode } = useEditor();

  useEffect(() => {
    if (!ref.current) return;

    editor.current = new JSONEditor({
      target: ref.current,
      props: {
        mode: "tree",
        theme: darkMode ? "dark" : "default",
        content: { json: jsonObject },
        onChange: (c) => {
          if (c.json) {
            setJsonObject(c.json);
            setJsonText(JSON.stringify(c.json, null, 2));
          }
        }
      }
    });

    return () => editor.current?.destroy();
  }, [darkMode]);

  return <div className="w-1/2 h-full" ref={ref} />;
}