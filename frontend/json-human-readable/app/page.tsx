// FILE: app/page.tsx
"use client";


import React, { useState } from "react";


export default function Home() {
const [input, setInput] = useState("");
const [output, setOutput] = useState("");
const [error, setError] = useState<string | null>(null);


const makeHumanReadable = (obj: any, indent = 4): string => {
const spacing = " ".repeat(indent);
let result = "";


if (Array.isArray(obj)) {
result += `${spacing}- List with ${obj.length} item(s):\n`;
obj.forEach((item, index) => {
result += `${spacing} Item ${index + 1}:\n`;
result += makeHumanReadable(item, indent + 2);
});
} else if (typeof obj === "object" && obj !== null) {
Object.entries(obj).forEach(([key, value]) => {
if (typeof value === "object" && value !== null) {
result += `${spacing}- ${key}:\n`;
result += makeHumanReadable(value, indent + 1);
} else {
result += `${spacing}- ${key}: ${String(value)}\n`;
}
});
} else {
result += `${spacing}${String(obj)}\n`;
}


return result;
};


const handleConvert = () => {
try {
setError(null);
const parsed = JSON.parse(input);
setOutput(makeHumanReadable(parsed));
} catch (e) {
setOutput("");
setError("Invalid JSON. Please check your input.");
}
};


return (
<main className="min-h-screen p-6 bg-gray-50 grid grid-cols-1 md:grid-cols-2 gap-6">
<section className="bg-white rounded-2xl shadow p-4">
<h1 className="text-xl font-semibold mb-2">JSON Input</h1>
<textarea
className="w-full h-96 p-3 border rounded-lg font-mono text-sm"
placeholder="Paste JSON here"
value={input}
onChange={(e) => setInput(e.target.value)}
/>
<button
onClick={handleConvert}
className="mt-4 px-4 py-2 rounded-xl bg-black text-white"
>
Convert to Human Readable
</button>
{error && <p className="mt-2 text-red-600">{error}</p>}
</section>


<section className="bg-white rounded-2xl shadow p-4">
<h1 className="text-xl font-semibold mb-2">Human Readable Output</h1>
<pre className="w-full h-96 p-3 bg-gray-100 rounded-lg overflow-auto whitespace-pre-wrap text-sm">
{output || "Converted output will appear here"}
</pre>
</section>
</main>
);
}
