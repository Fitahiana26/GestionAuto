import { Navigate, Route, Routes } from "react-router-dom";
import LoginPage from "./pages/frontoffice/LoginPage";
import RegisterPage from "./pages/frontoffice/RegisterPage";
import SiteVoituresPage from "./pages/frontoffice/SiteVoituresPage";

export default function App() {
  return (
    <Routes>
      <Route path="/" element={<Navigate to="/voitures" replace />} />
      <Route path="/login" element={<LoginPage />} />
      <Route path="/register" element={<RegisterPage />} />
      <Route path="/voitures" element={<SiteVoituresPage />} />
    </Routes>
  );
}