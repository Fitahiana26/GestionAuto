import { useState } from "react";
import { errorMessage } from "../hooks/useAuth";
import type { RegisterData } from "../types/Auth";

interface Props {
  onSubmit: (data: RegisterData) => Promise<void>;
}

export default function RegisterForm({ onSubmit }: Props) {
  const [form, setForm] = useState<RegisterData>({
    name: "", firstName: "", email: "", password: "", contact: "",
  });
  const [error, setError] = useState<string | null>(null);
  const [loading, setLoading] = useState(false);

  const set = (k: keyof RegisterData) => (e: React.ChangeEvent<HTMLInputElement>) =>
    setForm({ ...form, [k]: e.target.value });

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    setError(null);
    setLoading(true);
    try {
      await onSubmit(form);
    } catch (err) {
      setError(errorMessage(err));
    } finally {
      setLoading(false);
    }
  };

  return (
    <form onSubmit={handleSubmit} style={{ display: "grid", gap: 8 }}>
      <input placeholder="Nom" required value={form.name} onChange={set("name")} />
      <input placeholder="Prénom" value={form.firstName} onChange={set("firstName")} />
      <input type="email" placeholder="Email" required value={form.email} onChange={set("email")} />
      <input placeholder="Téléphone" value={form.contact} onChange={set("contact")} />
      <input type="password" placeholder="Mot de passe" required minLength={6}
        value={form.password} onChange={set("password")} />
      {error && <p style={{ color: "red" }}>{error}</p>}
      <button type="submit" disabled={loading}>{loading ? "Inscription..." : "S'inscrire"}</button>
    </form>
  );
}