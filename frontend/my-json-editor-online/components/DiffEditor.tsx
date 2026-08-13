"use client";
import { DiffEditor } from '@monaco-editor/react';

export default function JsonDiff({ original, modified, darkMode }) {
  return (
    <DiffEditor
      height="100%"
      language="json"
      original={original}
      modified={modified}
      theme={darkMode ? 'vs-dark' : 'light'}
      options={{ readOnly: false }}
    />
  );
}