import { useEffect, useState } from "react";

import type { Voitures } from "../types/Voitures";
import { getVoitures } from "../services/VoitureService";

export function useVoitures() {
    const [voitures, setVoitures] = useState<Voitures[]>([]);
    const [loading, setLoading] = useState<boolean>(true);
    const [error, setError] = useState<string | null>(null);

    useEffect(() => {
        async function chargerVoitures() {
            try {
                const data = await getVoitures();
                setVoitures(data);
            } catch (error) {
                setError(
                    error instanceof Error
                        ? error.message
                        : "Une erreur inconnue est survenue."
                );
            } finally {
                setLoading(false);
            }
        }

        void chargerVoitures();
    }, []);

    return { voitures, loading, error };
}