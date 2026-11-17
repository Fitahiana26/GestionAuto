import { useEffect, useMemo, useState } from "react";
import { getVoitures } from "../services/VoitureService";
import type { Voiture, VoitureFiltres } from "../types/Voiture";

export function useVoitures(filtres: VoitureFiltres = {}, onlyIds?: number[]) {
  const [voitures, setVoitures] = useState<Voiture[]>([]);
  const [loading, setLoading] = useState<boolean>(false);
  const [error, setError] = useState<string | null>(null);

  const key = JSON.stringify(filtres);

  useEffect(() => {
    let alive = true;

    async function chargerVoitures() {
      try {
        setLoading(true);
        setError(null);

        const data = await getVoitures(JSON.parse(key) as VoitureFiltres);

        if (alive) {
          setVoitures(data);
        }
      } catch {
        if (alive) {
          setError("Impossible de charger les voitures.");
        }
      } finally {
        if (alive) {
          setLoading(false);
        }
      }
    }

    chargerVoitures();

    return () => {
      alive = false;
    };
  }, [key]);

  const list = useMemo(
    () =>
      onlyIds
        ? voitures.filter((v) => onlyIds.includes(v.idVoiture))
        : voitures,
    [voitures, onlyIds],
  );

  return { voitures: list, loading, error };
}
