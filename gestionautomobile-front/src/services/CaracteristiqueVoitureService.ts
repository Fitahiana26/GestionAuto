import axios from "axios";

import type { CaracteristiqueVoiture } from "../types/CaracteristiqueVoiture";

const API_BASE_URL = "/api";

export const getCaracteristiqueVoiture = async (): Promise<[CaracteristiqueVoiture]> => {
    const response = await axios.get(`${API_BASE_URL}/caracteristiqueVoiture`);
    return response.data;
};

export const getCaracteristiqueVoitureById = async (id: string): Promise<CaracteristiqueVoiture> => {
    const response = await axios.get(`${API_BASE_URL}/caracteristiqueVoiture/${id}`);
    return response.data;
};

export const createVoiture = async (caracteristiqueVoiture: Omit<CaracteristiqueVoiture, "idCaracteristiqueVoiture">): Promise<CaracteristiqueVoiture> => {
    const response = await axios.post(`${API_BASE_URL}/caracterisyiqueVoiture`, caracteristiqueVoiture);
    return response.data;
};